class Cliente extends Pessoa {

    constructor(nome, cpf, sexo, dataNascimento,email,dataCadastro) {
      super(nome, cpf, sexo, dataNascimento);
      this.salario = salario;
      this.senha = senha;
      this.dataCadastro = dataCadastro;
      
    }
}