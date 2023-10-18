<template>
<div>
  <Navbar/>

  <div class="text-center align-items-center m-lg-5">
    <b-card class=" bg-light" >
    <h2>Customer View</h2>
    <table class="table table-bordered">
      <thead class="">
      <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Address</th>
        <th scope="col">Mobile</th>
        <th scope="col">Option</th>
      </tr>
      </thead>
      <tbody>

      <tr v-for="customer in result" :key="customer.id">

        <td>{{ customer.id }}</td>
        <td>{{ customer.name }}</td>
        <td>{{ customer.email }}</td>
        <td>{{ customer.address }}</td>
        <td>{{ customer.mobile }}</td>
        <td>
          <button type="button" class="btn btn-warning" @click="edit(customer)">Edit</button>
          <button type="button" class="btn btn-danger"  @click="remove(customer)">Delete</button>
        </td>
      </tr>

      </tbody>
    </table>
    </b-card>
  </div>
</div>
</template>

<script>
import axios from "axios";
import Navbar from "./Navbar.vue";


export default {
  name: "CustomerList",
  components: {Navbar},
  data() {
    return {
      result: {},

      customer: {
        id: '',
        name: '',
        email: '',
        address: '',
        mobile: ''
      }
    }
  },
  created() {
    this.CustomerLoad();
  },
  methods: {
    CustomerLoad() {
      axios.get("http://localhost:8084/api/v1/customer/getAllCustomer")
        .then(({data}) => {
          this.result = data;
        })
        .catch(error => {
          console.error("Erro ao buscar dados:", error);
        });
    },
    remove(customer) {
      axios.delete(`http://localhost:8084/api/v1/customer/deletecustomer/${customer.id}`)
      alert("Deleteddd");
      this.CustomerLoad();
    },

    edit(customer) {
      axios.put("http://localhost:8084/api/v1/customer/update/", this.customer)
        .then(
          ({data}) => {
            this.customer.id = null;
            this.customer.name = null;
            this.customer.address = null;
            this.customer.mobile = null;
            this.customerid = ''
            alert("Updated!!!");
            this.CustomerLoad();
          }
        );
      }
    }
  }

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
