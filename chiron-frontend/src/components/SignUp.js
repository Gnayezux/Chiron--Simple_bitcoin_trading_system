/**
 * 
 */

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
  baseURL: "http://localhost:8082/"

  // headers: {'Access-Control-Allow-Origin': frontendUrl}
});

export default {
  name: "register",
  data() {
    return {
      User_Type: [
        { text: "Adopter" },
        { text: "Provider" },
        { text: "Manager" }
      ],
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
   export register(selectedType, name, email, password, ID) {
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
      } else if(selectedType.localeCompare("M") == 0){

        
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
