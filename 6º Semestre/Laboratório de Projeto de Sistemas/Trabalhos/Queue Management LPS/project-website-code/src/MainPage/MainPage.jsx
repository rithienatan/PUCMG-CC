/*----------imports----------*/
import React from 'react';

/*----------imports components----------*/
import Labels from '../components/Labels.jsx';

/*---------- classes and functions ----------*/
class MainPage extends React.Component {
    
    render(){
        return(
            <div className="container">
                <div className="login">
                    <h1><Labels name="Login" /></h1>
                    <div className="login__buttons">
                        <button className="login__buttons--gerente">Gerente</button>
                        <button className="login__buttons--cliente">Cliente</button>
                    </div>
                </div>

                <div className="cadastro">
                    <h1><Labels name="Cadastro" /></h1>
                    <div className="cadastro__buttons">
                        <button className="cadastro__buttons--gerente">Gerente</button>
                        <button className="cadastro__buttons--cliente">Cliente</button>
                    </div>
                </div>
            </div>
        );
    }//end render
}//end class

export default MainPage;