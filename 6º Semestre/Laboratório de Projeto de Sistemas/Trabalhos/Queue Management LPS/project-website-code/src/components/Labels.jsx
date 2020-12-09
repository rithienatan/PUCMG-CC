/*----------imports----------*/
import React from 'react';
import './Labels.scss';

/*---------- classes and functions ----------*/
class Labels extends React.Component{
    render()
    {
        return(
            <label>{this.props.name}</label>
        );
    }//end render()
}//end class

export default Labels;