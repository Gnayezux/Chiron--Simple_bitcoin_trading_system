<template>
  <div>
    <form v-if="!isReg">
      <div>UserName:</div>
      <input type="text" v-model="name">
      <div>Password:</div>
      <input type="password" v-model="password">
      <button type="button" @click="login()">login</button>
      <button type="button" @click="reg()">SignUp</button>
    </form>
    <form v-else>
      <div>UserName:</div>
      <input type="text" v-model="name">
      <div>Password:</div>
      <input type="password" v-model="password">
      <div>Re-Enter Password:</div>
      <input type="password" v-model="repeat">
      <button type="button" @click="addUser()">YES</button>
      <button type="button" @click="cancel()">Cancel</button>
    </form>
  </div>
</template>

<script>
export default {
  name: "login",
  data() {
    return {
      isReg: false,
      name: "",
      password: "",
      repeat: ""
    };
  },
  methods: {
    login() {
      //验证姓名和Password是否与locastorage一致
      if (
        localStorage.getItem("name") === this.name &&
        localStorage.getItem("password") === this.password
      ) {
        //清空输入框
        this.name = "";
        this.password = "";
        this.$router.push("/home/list");
      }else{
        alert('User name or password are incorrect');
      }
    },
    reg() {
      this.isReg = true;
    },
    cancel() {
      this.isReg = false;
    },
    addUser() {
      //验证两次输入Password是否一致
      if (this.password === this.repeat) {
        //将名字和Password存入localstorage中
        localStorage.setItem("name", this.name);
        localStorage.setItem("password", this.password);
        //清空输入框
        this.name = "";
        this.password = "";
        this.isReg = false;
      } else {
        alert("The two passwords are not the same");
      }
    }
  }
};
</script>

<style scoped>
</style>