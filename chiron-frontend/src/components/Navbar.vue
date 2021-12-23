a<!-- This is  the header-area -->
<template>
  <div>
    <div id="forPop"></div>
    <b-navbar toggleable="lg" type="dark" id="nav_bar">
      <b-navbar-brand href="#">
        <img src="https://placekitten.com/g/30/30" alt="Kitten" />Chiron
      </b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
      <b-collapse id="nav-collapse" is-nav>
        <!-- Right aligned nav items -->
        <b-navbar-nav class="ml-auto">
          <b-nav-item href="http://localhost:8080/#/">Home</b-nav-item>
          <b-nav-item href="/#/buybitcoin">Buy Bitcoins</b-nav-item>
          <b-nav-item href="/#/sellbitcoin">Sell Bitcoins</b-nav-item>
          <b-nav-item-dropdown text="My Account" right>
            <b-dropdown-item @click="showL">Login</b-dropdown-item>
            <b-dropdown-item @click="showR">Sign up</b-dropdown-item>
          </b-nav-item-dropdown>
          <b-nav-item @click="showDonation">Donation</b-nav-item>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>

    <div v-if="isActive" class="registerPart">
      <div class="container">
        <b-dropdown-item @click="closeR">Close</b-dropdown-item>
        <h1>Register</h1>
        <p>Please fill in this form to create an account.</p>
        <hr />

        <label for="ID">User Id</label>
        <input
          type="text"
          placeholder="Enter User Id"
          name="ID"
          required
          v-model="ID"
        />

        <label for="selectedType">User Type (A, P or M)</label>
        <input
          type="text"
          placeholder="Enter selectedType"
          name="selectedType"
          required
          v-model="selectedType"
        />

        <label for="name">
          <b>Name</b>
        </label>
        <input
          type="text"
          placeholder="Enter Name"
          name="name"
          required
          v-model="name"
        />

        <label for="email">
          <b>Email</b>
        </label>
        <input
          type="text"
          placeholder="Enter Email"
          name="email"
          required
          v-model="email"
        />

        <label for="password">
          <b>Password</b>
        </label>
        <input
          type="password"
          placeholder="Enter Password"
          name="password"
          required
          v-model="password"
        />

        <!-- <label for="psw-repeat"><b>Repeat Password</b></label>
        <input type="password" placeholder="Repeat Password" name="psw-repeat" required>-->
        <hr />

        <p>
          By creating an account you agree to our
          <a href="#">Terms & Privacy</a>.
        </p>
        <input
          @click="register(selectedType, name, email, password, ID)"
          type="submit"
          value="Register"
          class="btn btn-primary py-2 px-4 text-white"
        />
      </div>

      <div class="container signin">
        <p>
          Already have an account?
          <a href="#">Sign in</a>.
        </p>
      </div>
    </div>

    <div v-if="isLog" class="registerPart">
      <div class="containerL">
        <b-dropdown-item @click="closeL">Close</b-dropdown-item>
        <h1>Log in</h1>
        <hr />
        <label for="name">
          <b>Name</b>
        </label>
        <input type="text" placeholder="Enter Name" name="name" required />

        <label for="psw">
          <b>Password</b>
        </label>
        <input
          type="password"
          placeholder="Enter Password"
          name="psw"
          required
        />
        <hr />
        <button type="submit" class="registerbtn">Register</button>
      </div>
    </div>

    <div v-if="isDonation" class="donationPart">
      <div class="containerDonation">
        <b-dropdown-item @click="closeDonation">Close</b-dropdown-item>
        <h1>Be a Sponser!</h1>
        <hr />
        <label for="name">
          <b>Name</b>
        </label>
        <input type="text" placeholder="Enter Name" name="name" required />

        <label for="Amount">
          <b>Amount</b>
        </label>
        <input
          type="password"
          placeholder="Enter Password"
          name="psw"
          required
        />
        <hr />
        <button type="submit" class="registerbtn">Donate</button>
      </div>
    </div>
  </div>
</template>

<script>
import _ from "lodash";
import axios from "axios";
let config = require("../../config");

let backendConfigurer = function() {
  switch (process.env.NODE_ENV) {
    case "testing":
    case "development":
      return "http://localhost:8082/";
    case "production":
      return (
        "https://" + config.build.backendHost + ":" + config.build.backendPort
      );
  }
};

let backendUrl = backendConfigurer();

let AXIOS = axios.create({
  baseURL: backendUrl

  // headers: {'Access-Control-Allow-Origin': frontendUrl}
});

export default {
  data() {
    return {
      isActive: false,
      isLog: false,

      isDonation: false,

      selectedType: "",
      Name: "",
      ID: "",
      email: "",
      password: "",
      errorRegister: "",
      response: ""
    };
  },

  created: function() {},
  methods: {
    showR: function() {
      return (this.isActive = true);
    },
    showL: function() {
      return (this.isLog = true);
    },
    showDonation: function() {
      return (this.isDonation = true);
    },
    closeR: function() {
      return (this.isActive = false);
    },
    closeL: function() {
      return (this.isLog = false);
    },
    closeDonation: function() {
      return (this.isDonation = false);
    },

    register(selectedType, name, email, password, ID) {
      if (selectedType != "A") {
        if (selectedType != "P") {
          if (selectedType != "M") {
            var errorMsg = "please select a correct user type (A, P or M)";
            console.log(errorMsg);
            this.errorRegister = errorMsg;
            return;
          }
        }
      }

      if (name == "") {
        var errorMsg = "Invalid name";
        console.log(errorMsg);
        this.errorRegister = errorMsg;
        return;
      }
      if (ID == "") {
        var errorMsg = "Invalid id";
        console.log(errorMsg);
        this.errorRegister = errorMsg;
        return;
      }
      if (email == "") {
        var errorMsg = "Invalid email";
        console.log(errorMsg);
        this.errorRegister = errorMsg;
        return;
      }
      if (password == "") {
        var errorMsg = "Invalid password";
        console.log(errorMsg);
        this.errorRegister = errorMsg;
        return;
      }

      AXIOS.get("check/repeat?id=" + ID).then(response => {
        if (response.data) {
          var errorMsg = "Please enter a new ID. This is a repeated one.";
          console.log(errorMsg);
          this.ID = errorMsg;
          return;
        }
      });

      //------------------------------For Adopter -----------------------
      if (selectedType.localeCompare("A") == 0) {
        let params = {
          name: name,
          password: password,
          email: email
        };

        AXIOS.post("adopter/".concat(ID), {}, { params: params })
          .then(response => {
            // JSON responses are automatically parsed.
            this.response = response.data;
            console.log(this.response);
            if (this.response.name == null) {
              this.errorRegister = "ID is not a Valid Admin ID!";
              this.response = "";
            } else {
              this.response = "Admin Created!";
              this.errorRegister = "";
            }
            this.selectedType = "";
            this.Name = "";
            this.ID = "";
            this.email = "";
            this.password = "";
          })
          .catch(e => {
            e = e.response.data.message ? e.response.data.message : e;
            this.errorRegister = e;
            this.response = "";
            console.log(e);
          });
      }

      //------------------------------For Provider -----------------------
      else if (selectedType.localeCompare("P") == 0) {
        let params = {
          name: name,
          password: password,
          email: email
        };

        AXIOS.post("provider/".concat(ID), {}, { params: params })
          .then(response => {
            // JSON responses are automatically parsed.
            this.response = response.data;
            console.log(this.response);
            if (this.response.name == null) {
              this.errorRegister = "ID is not a Valid Admin ID!";
              this.response = "";
            } else {
              this.response = "Admin Created!";
              this.errorRegister = "";
            }
            this.selectedType = "";
            this.Name = "";
            this.ID = "";
            this.email = "";
            this.password = "";
          })
          .catch(e => {
            e = e.response.data.message ? e.response.data.message : e;
            this.errorRegister = e;
            this.response = "";
            console.log(e);
          });
      } else if (selectedType.localeCompare("M") == 0) {
        let params = {
          name: name,
          password: password,
          email: email
        };

        AXIOS.post("petsheltermanager/".concat(ID), {}, { params: params })
          .then(response => {
            // JSON responses are automatically parsed.
            this.response = response.data;
            console.log(this.response);
            if (this.response.name == null) {
              this.errorRegister = "ID is not a Valid Admin ID!";
              this.response = "";
            } else {
              this.response = "Admin Created!";
              this.errorRegister = "";
            }
            this.selectedType = "";
            this.Name = "";
            this.ID = "";
            this.email = "";
            this.password = "";
          })
          .catch(e => {
            e = e.response.data.message ? e.response.data.message : e;
            this.errorRegister = e;
            this.response = "";
            console.log(e);
          });
      }
    }
  }
};
</script>

<style scoped>
.container {
  margin-top: -200px;
  padding: 16px;
  background: black;
}
.containerL {
  margin-top: -50px;
  padding: 16px;
  background: black;
}
.containerDonation {
  margin-top: -50px;
  padding: 16px;
  background: black;
}
/* Full-width input fields */

input[type="text"],
input[type="password"] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type="text"]:focus,
input[type="password"]:focus {
  background-color: #ddd;
  outline: none;
}
/* Overwrite default styles of hr */

hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}
/* Set a style for the submit/register button */

.registerbtn {
  background-color: #4caf50;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}
/* Add a blue text color to links */

a {
  color: dodgerblue;
}
/* Set a grey background color and center the text of the "sign in" section */

.signin {
  margin-top: 0.1px;
  background-color: #000000;
  text-align: center;
}

#nav_bar {
  font-family: "Poppins", sans-serif;
  font-weight: 300;
  color: #ffff;
  padding-right: 30px;
  background: rgba(0, 0, 0, 0.2);
}

.registerPart {
  background-color: #000000;
  font-family: "Poppins", sans-serif;
  font-weight: 300;
  color: #ffff;
  width: 500px;
  height: 400px;
  position: fixed;
  left: 50%;
  top: 50%;
  margin-top: -200px;
  margin-left: -250px;
}

.donationPart {
  background-color: #000000;
  font-family: "Poppins", sans-serif;
  font-weight: 300;
  color: #ffff;
  width: 500px;
  height: 400px;
  position: fixed;
  left: 50%;
  top: 50%;
  margin-top: -200px;
  margin-left: -250px;
}

#forPop {
  width: 100%;
  height: 100%;
  top: 0px;
  left: 0px;
  filter: Alpha(opacity=60);
  opacity: 0.6;
  background: #000000;
  display: block;
}
</style>
