<template>
  <div>
    <Navbar/>
    <b-card class="col-md-6 bg-light m-lg-5" >
      <h2 class="text-center">Cadastro de Cliente</h2>
      <form @submit.prevent="login">

        <div class="form-group mt-3">
          <label>Nome</label>
          <input type="text" v-model="customer.name" class="form-control"  placeholder="Digite seu name">
        </div>

        <div class="form-group mt-3">
          <label class="">Endereço</label>
          <input type="password" v-model="customer.password" class="form-control"  placeholder="Digite sua senha">

        </div>

        <div class="text-center">
          <button type="submit" class="btn btn-primary mt-3 " >Login</button>
        </div>
      </form>
    </b-card>
  </div>
</template>
<script >
import Navbar from "./Navbar.vue";
import axios from "axios";

export default {
  name: "Login",
  components: {Navbar},
  data() {
    return {
      customer: {
        email: '',
        password: ''
      }
    };
  },
  methods: {
    login() {

      axios.post("http://localhost:8084/login", this.customer)
        .then((response) => {
          // Lidar com a resposta do back-end após o login bem-sucedido
          console.log("Token de autenticação: " + response.data.token);
        })
        .catch((error) => {
          // Lidar com erros, como credenciais inválidas
          console.error("Erro ao fazer login: " + error);
        });
    },
  }
}
</script>



<style scoped>

</style>
