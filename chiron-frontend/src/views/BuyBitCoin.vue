<template>
  <v-app id="inspire">
    <div>
      <header id="banner-area">
        <div class="container">
          <web-navbar></web-navbar>
          <div id="banner-content">
            <h1 class="text-uppercase">The simplest way to invest in crypto</h1>
            <p class="text-white sub-head">
              Buy Bitcoin and Ethereum instantly.
            </p>
          </div>
        </div>
      </header>
      <!-- This is  the category-area -->
      <div class="container marketing" id="category-area">
        <!-- Three columns of text below the carousel -->
        <template>
          <v-data-table
            :headers="headers"
            :items="desserts"
            sort-by="seller"
            class="elevation-1"
          >
            <template v-slot:top>
              <v-toolbar flat>
                <v-toolbar-title>Buy bitcoins online in Canada</v-toolbar-title>
                <v-divider class="mx-4" inset vertical></v-divider>
                <v-spacer></v-spacer>
                <v-dialog v-model="dialog" max-width="500px">
                  <template v-slot:activator="{ on, attrs }">
                    <v-btn
                      color="primary"
                      dark
                      class="mb-2"
                      v-bind="attrs"
                      v-on="on"
                    >
                      New Item
                    </v-btn>
                  </template>
                  <v-card>
                    <v-card-title>
                      <span class="headline">{{ formTitle }}</span>
                    </v-card-title>

                    <v-card-text>
                      <v-container>
                        <v-row>
                          <v-col cols="12" sm="6" md="4"> </v-col>
                          <v-col cols="12" sm="6" md="4">
                            <v-text-field
                              v-model="editedItem.seller"
                              label="seller"
                            ></v-text-field>
                          </v-col>
                          <v-col cols="12" sm="6" md="4">
                            <v-text-field
                              v-model="editedItem.pay_method"
                              label="pay_method (g)"
                            ></v-text-field>
                          </v-col>
                          <v-col cols="12" sm="6" md="4">
                            <v-text-field
                              v-model="editedItem.price"
                              label="price (g)"
                            ></v-text-field>
                          </v-col>
                          <v-col cols="12" sm="6" md="4">
                            <v-text-field
                              v-model="editedItem.limit"
                              label="limit (g)"
                            ></v-text-field>
                          </v-col>
                        </v-row>
                      </v-container>
                    </v-card-text>

                    <v-card-actions>
                      <v-spacer></v-spacer>
                      <v-btn color="blue darken-1" text @click="close">
                        Cancel
                      </v-btn>
                      <v-btn color="blue darken-1" text @click="save">
                        Save
                      </v-btn>
                    </v-card-actions>
                  </v-card>
                </v-dialog>
                <v-dialog v-model="dialogDelete" max-width="500px">
                  <v-card>
                    <v-card-title class="headline"
                      >Are you sure you want to delete this item?</v-card-title
                    >
                    <v-card-actions>
                      <v-spacer></v-spacer>
                      <v-btn color="blue darken-1" text @click="closeDelete"
                        >Cancel</v-btn
                      >
                      <v-btn
                        color="blue darken-1"
                        text
                        @click="deleteItemConfirm"
                        >OK</v-btn
                      >
                      <v-spacer></v-spacer>
                    </v-card-actions>
                  </v-card>
                </v-dialog>
              </v-toolbar>
            </template>
            <template v-slot:item.actions="{ item }">
              <v-icon small class="mr-2" @click="editItem(item)">
                mdi-pencil
              </v-icon>
              <v-icon small @click="deleteItem(item)">
                mdi-delete
              </v-icon>
            </template>
            <template v-slot:no-data>
              <v-btn color="primary" @click="initialize">
                Reset
              </v-btn>
            </template>
          </v-data-table>
        </template>
      </div>
      <web-footer></web-footer></div
  ></v-app>
</template>

<script>
import Footer from "../components/Footer.vue";
import Navbar from "../components/Navbar.vue";
export default {
  components: {
    "web-navbar": Navbar,
    "web-footer": Footer
  },
  data: () => ({
    dialog: false,
    dialogDelete: false,
    headers: [
      { text: "Seller", value: "seller" },
      { text: "Payment method", value: "pay_method" },
      { text: "Price / BTC", value: "price" },
      { text: "Limits", value: "limit" },
      { text: "Actions", value: "actions", sortable: false }
    ],
    dessertss: [],
    editedIndex: -1,
    editedItem: {
      name: "",
      seller: 0,
      pay_method: 0,
      price: 0,
      limit: 0
    },
    defaultItem: {
      name: "",
      seller: 0,
      pay_method: 0,
      price: 0,
      limit: 0
    }
  }),

  computed: {
    formTitle() {
      return this.editedIndex === -1 ? "New Item" : "Edit Item";
    }
  },

  watch: {
    dialog(val) {
      val || this.close();
    },
    dialogDelete(val) {
      val || this.closeDelete();
    }
  },

  created() {
    this.initialize();
  },

  methods: {
    initialize() {
      this.desserts = [
        {
          name: "Frozen Yogurt",
          seller: 159,
          pay_method: 6.0,
          price: 24,
          limit: 4.0
        },
        {
          name: "Ice cream sandwich",
          seller: 237,
          pay_method: 9.0,
          price: 37,
          limit: 4.3
        },
        {
          name: "Eclair",
          seller: 262,
          pay_method: 16.0,
          price: 23,
          limit: 6.0
        },
        {
          name: "Cupcake",
          seller: 305,
          pay_method: 3.7,
          price: 67,
          limit: 4.3
        },
        {
          name: "Gingerbread",
          seller: 356,
          pay_method: 16.0,
          price: 49,
          limit: 3.9
        },
        {
          name: "Jelly bean",
          seller: 375,
          pay_method: 0.0,
          price: 94,
          limit: 0.0
        },
        {
          name: "Lollipop",
          seller: 392,
          pay_method: 0.2,
          price: 98,
          limit: 0
        },
        {
          name: "Honeycomb",
          seller: 408,
          pay_method: 3.2,
          price: 87,
          limit: 6.5
        },
        {
          name: "Donut",
          seller: 452,
          pay_method: 25.0,
          price: 51,
          limit: 4.9
        },
        {
          name: "KitKat",
          seller: 518,
          pay_method: 26.0,
          price: 65,
          limit: 7
        }
      ];
    },

    editItem(item) {
      this.editedIndex = this.desserts.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.dialog = true;
    },

    deleteItem(item) {
      this.editedIndex = this.desserts.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.dialogDelete = true;
    },

    deleteItemConfirm() {
      this.desserts.splice(this.editedIndex, 1);
      this.closeDelete();
    },

    close() {
      this.dialog = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      });
    },

    closeDelete() {
      this.dialogDelete = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      });
    },

    save() {
      if (this.editedIndex > -1) {
        Object.assign(this.desserts[this.editedIndex], this.editedItem);
      } else {
        this.desserts.push(this.editedItem);
      }
      this.close();
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#category-area {
  padding-top: 70px;
  padding-bottom: 70px;
  font-family: inherit;
  background-color: rgba(255, 255, 255, 0.904);
}
#category-title {
  padding-top: 20px;
  padding-bottom: 10px;
  padding-left: 100px;
}
#category-body {
  text-align: justify;
}
#banner-area {
  background-image: url("../assets/Bitcoin.jpg");
  background-size: cover;
  padding-bottom: 350px;
}
#banner-content {
  padding-top: 100px;
  color: #ffff;
  padding-left: 700px;
  padding-bottom: 100px;
}
</style>
