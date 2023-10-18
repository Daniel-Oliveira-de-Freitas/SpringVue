<template>
<div class="">
  <Navbar/>

  <b-card class="col-md-6 bg-light m-lg-5" >
    <h2 class="text-center">Cadastro de Cliente</h2>
    <form @submit.prevent="save">

      <div class="form-group mt-3">
        <label>Nome</label>
        <input type="text" v-model="customer.name" class="form-control"  placeholder="Digite seu name">
      </div>

      <div class="form-group mt-3">
        <label class="">Email</label>
        <input type="text" v-model="customer.email" class="form-control"  placeholder="Digite seu email">

      </div>

      <div class="form-group mt-3">
        <label class="">Senha</label>
        <input type="password" v-model="customer.password" class="form-control"  placeholder="Digite sua senha">

      </div>

      <div class="form-group mt-3 ">
        <label class="">Endereço</label>
        <input type="text" v-model="customer.address" class="form-control"  placeholder="Digite seu endereço">

      </div>

      <div class="form-group mt-3">
        <label>Telefone</label>
        <input type="text" v-model="customer.mobile" class="form-control"  placeholder="Digite seu contato">

      </div>
      <div class="text-center">
          <button type="submit" class="btn btn-primary mt-3 " >Salvar</button>
      </div>
    </form>
  </b-card>

</div>
</template>

<script>
import axios from 'axios';
import Navbar from "./Navbar.vue";
export default {
  name: 'CustomerCrud',
  components: {Navbar},
  data () {
    return {
      result: {},

      customer:{
        name: "",
        email: "",
        password:"",
        address: "",
        mobile: ""
      }
    }
  },


  methods: {
    save() {
      console.log("Entrou aqui no save!")
      axios.post("http://localhost:8084/api/v1/customer/save", this.customer)
        .then(
          ({data})=>{
            this.customer.name = ''
            this.customer.address = ''
            this.customer.mobile = ''
            alert("Cliente salvo com sucesso!!")
            this.$router.push('/');
          }
        )

    },

  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style >

</style>
