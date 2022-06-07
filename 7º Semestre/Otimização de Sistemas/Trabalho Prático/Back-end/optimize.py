# ---------- import libs ---------
import pulp as p
import json

# ---------- function ----------
def aplicateCplex(object):
    Lp_prob = p.LpProblem('Task Optimization', p.LpMaximize)

    # Atribui binaridade para as variaveis de decisão
    auxArray = []
    for i in range(object["numTasks"]):
        auxArray.append(p.LpVariable(object["tasksArray"][i]["taskName"], lowBound=0, upBound=1))

    # Atribui a função objetivo
    funcObjective = None
    for i in range(object["numTasks"]):
        funcObjective += auxArray[i]

    Lp_prob += funcObjective

    # Atribui restrição de excedencia de horario para cada Task
    timeRestriction = None
    for i in range(object["numTasks"]):
        timeRestriction += auxArray[i] * object["tasksArray"][i]["taskHour"]

    Lp_prob += timeRestriction <= object["totalTime"]

    # Atribui restrição de prioridade de tarefas
    for i in range(object["numTasks"]):
        if object["tasksArray"][i]["priority"] == True:
            Lp_prob += auxArray[i] == 1

    # print(Lp_prob)

    # Cplex solver
    solver = p.CPLEX_PY()
    status = Lp_prob.solve(solver)

    # answer
    answer = {
        "status": p.LpStatus[status],
        "funcObjetivo": p.value(Lp_prob.objective),
        "tasksArray": []
    }
    
    for i in range(object["numTasks"]):
        if p.value(auxArray[i]) == 1:
            answer["tasksArray"].append(object["tasksArray"][i]["taskName"])

    return json.dumps(answer)