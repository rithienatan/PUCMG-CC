//----------- lib(s) and other(s) ------------
import { React, useState, useRef } from 'react';


//----------- styles imports ---------
import './App.css';
import { 
  Container, FormGroup, TextField,
  Button, Select, MenuItem, InputLabel,
  StyledEngineProvider, Checkbox,
  FormControl, FormControlLabel,
  Box, Divider, CircularProgress
} from '@mui/material';

//----------- App Function ---------
/**
 * Main App
 * 
 * @returns {JSX}
 */
function App() {
  //----------- objects -----------
  const [numTasks, setNumTasks] = useState(1);
  const [totalTime, setTotalTime] = useState('');
  const [userInputs, setUserInputs] = useState([{"taskName": '', "taskHour": '', "priority": false}]);
  const [finalOutput, setFinalOutput] = useState({"status": '', "funcObjetivo": '', "tasksArray": []});

  //----------- aux components setting -----------
  const maxNumbers = useRef([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]);
  const [tasksArray, setTasksArray] = useState([1]);

  //----------- handle functions -----------
  const numTasksHandle = (event) => {
    let eventValue = event.target.value;

    //----- setNumTasks -----
    setNumTasks(eventValue);

    let auxArray = [];
    let auxUserInputArray = [];

    if(eventValue >= numTasks)
    {
      auxArray = tasksArray;
      auxUserInputArray = userInputs;

      //----- update taskArray and userInput array -----
      for(let i = tasksArray.length; i < eventValue; i++)
      { 
        auxArray[i] = i + 1; 
        auxUserInputArray[i] = {"taskName": '', "taskHour": '', "priority": false};
      }//end for
    }
    else
    {
      for(let i = 0; i < eventValue; i++)
      {
        auxArray[i] = tasksArray[i];
        auxUserInputArray[i] = userInputs[i];
      }//end for
    }//end if
    
    setTasksArray(auxArray);
    setUserInputs(auxUserInputArray);
  };

  const totalTimeHandle = (event) => {
    if(event.target.value > 0)
    { setTotalTime(parseInt(event.target.value)); }
    else
    { alert("O seu tempo disponível deve ser maior que 0."); }
  };

  const taskNameHandle = (key, value) => {
    let auxVariable = userInputs;

    auxVariable[key-1].taskName = value;

    setUserInputs(auxVariable);
  };

  const taskHourHandle = (key, value) => {
    if(value > 0)
    {
      let auxVariable = userInputs;

      auxVariable[key-1].taskHour = parseInt(value);

      setUserInputs(auxVariable);
    }
    else
    { alert("O tempo de conclusão da tarefa deve ser maior que 0."); }
  };

  const taskPriorityHandle = (key, value) => {
    let auxVariable = userInputs;

    auxVariable[key-1].priority = value;

    setUserInputs(auxVariable);
  };

  //----------- event buttons -----------
  const Enviar = async () => {
    //verifica inputs vazios
    for(let i = 0; i < numTasks; i++)
    { 
      if(userInputs[i].taskName === null || userInputs[i].taskName === "" || userInputs[i].taskHours === null)
      { i = numTasks; return(alert("Não foi possível prosseguir! Campo(s) vazio(s)!")); }
    }//end for

    if(totalTime !== null || totalTime !== "")
    {
      let url = BASE_URL_ENV;

      let data = {
        "numTasks": numTasks,
        "totalTime": totalTime,
        "tasksArray": userInputs
      };

      let options = {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
      };

      await fetch(url, options)
      .then(res => res.json())
      .then(json => { setFinalOutput(json); })
      .catch(err => console.log(err));
    }
    else
    { alert("Digite o seu tempo total disponível!"); }
  };

  const LimparInputs = () => {
    setNumTasks(1);
    setTotalTime(null);
    window.location.reload();
  };

  return (
    <Container className="App">
      <StyledEngineProvider injectFirst>
        <header>
          <Container>
            <h1>Otimize suas tarefas!</h1>
          </Container>
        </header>

        <main>
          <FormControl fullWidth>
            <FormGroup row>
              <InputLabel id="select-num-tasks-label">Quantidade de Afazeres</InputLabel>
              <Select  
                labelId="select-num-tasks-label"
                label="Quantidade de Afazeres"
                value={numTasks}
                onChange={numTasksHandle}
                sx={{ width: "100%" }}
              >
                {maxNumbers.current.map((element) => {
                  return <MenuItem key={element} value={element}>{element}</MenuItem>
                })}
              </Select>

              <TextField 
                label="Digite o seu tempo total disponível em Horas"
                type="number"
                value={totalTime}
                onChange={totalTimeHandle}
                fullWidth
              />

              <h3>Seus Afazeres</h3>
              <Container>
                {tasksArray.map((element, index) => {
                  return(
                    <Box
                      key={element} 
                      sx={{ display: "flex", justifyContent: "space-between"}}
                    >
                      <TextField 
                        label="Nome da tarefa"
                        type="text"
                        sx={{ maxWidth: "55vh" }}
                        fullWidth
                        onChange={(event) => taskNameHandle(element, event.target.value)}
                      />
                      <TextField 
                        label="Quantidade em horas para a tarefa ser concluída"
                        type="number" 
                        sx={{ maxWidth: "45vh" }}
                        fullWidth
                        onChange={(event) => taskHourHandle(element, event.target.value)}
                      />
                      <FormControlLabel 
                        value="top"
                        control={<Checkbox onChange={(event) => taskPriorityHandle(element, event.target.checked)} />}
                        label="Necessidade"
                        labelPlacement="top"
                      />
                    </Box>
                  );
                })}
              </Container>

              <Button
                fullWidth
                variant="contained"
                onClick={() => Enviar()}
              >
                Enviar
              </Button>

              <Button
                variant="contained" 
                fullWidth 
                onClick={() => LimparInputs()}>
                  Limpar inputs
              </Button>
            </FormGroup>
          </FormControl>

          <Container>
            <h3>Otimização</h3>
            <Divider />
            <Container>
              <>
                <h4>Status: </h4>
                <p>{finalOutput.status}</p>
                <Divider />

                <h4>Quantidade de tarefas recomendadas:</h4>
                <p>{Math.floor(finalOutput.funcObjetivo)}</p>
                <Divider />

                <h4>Tarefas recomendadas:</h4>
                {finalOutput.tasksArray.map((element, index) => {
                  return <p key={index}>{element}</p>
                })}
              </>  
            </Container>
          </Container>
        </main>
      </StyledEngineProvider>
    </Container>
  );
}//end App()

export default App;

/*
 
*/
