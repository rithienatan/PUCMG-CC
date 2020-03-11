class Gerente extends Pessoa {

    constructor(nome, cpf, sexo, dataNascimento,email,salario,senha) {
      super(nome, cpf, sexo, dataNascimento);
      this.salario = salario;
      this.senha = senha;
    }
}