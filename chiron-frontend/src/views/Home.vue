<template>
  <div>
    <header id="banner-area">
      <div class="container">
        <web-navbar></web-navbar>
        <div id="banner-content">
          <h1 class="text-uppercase">
            Buy and Sell Bitcoin Everywhere
            <br />Near you or around the globe.
          </h1>

          <p class="text-white sub-head">
            Trade bitcoins person-to-person in an easy, fast, and secure way.
          </p>
          <b-button variant="outline-light" href="/#/buybitcoin"
            >Sign up Free</b-button
          >
        </div>
      </div>
    </header>
    <!-- This is  the process-area -->
    <section id="process-area">
      <div class="container">
        <div class="row d-flex justify-content-center">
          <div>
            <div class="title text-center">
              <h1 class="mb-10" style="padding-bottom:30px">
                Your Choice for Bitcoins
              </h1>
            </div>
          </div>
        </div>
        <div class="row" style="padding-left:200px">
          <div class="col-lg-5 col-md-6 pl-5">
            <div class="single-process">
              <b-icon
                icon="cart"
                font-scale="7"
                style="margin-left: 40px; margin-bottom: 40px"
              ></b-icon>
              <a href="/#/buybitcoin">
                <h4>Buy Bitcoins</h4>
              </a>
              <p>
                There's no account minimums, no paperwork, lots of investment
                options. Get started here.
              </p>
            </div>
          </div>

          <div class="col-lg-5 col-md-6">
            <div class="single-process">
              <b-icon
                icon="cash"
                font-scale="7"
                style="margin-left: 40px; margin-bottom: 40px"
              ></b-icon>
              <a href="/#/sellbitcoin">
                <h4>Sell Bitcoins</h4>
              </a>
              <p>
                Get paid via bank transfers, online wallets, gift cards, and
                over 350 other payment methods
              </p>
            </div>
          </div>
        </div>
      </div>
    </section>
    <web-footer></web-footer>
  </div>
</template>
<script src="../router/popup.js"></script>
<script>
import Footer from "../components/Footer.vue";
import Navbar from "../components/Navbar.vue";

export default {
  data() {
    return {
      isActive: false
    };
  },
  methods: {
    showR: function() {
      return (this.isActive = true);
    }
  },

  components: {
    "web-navbar": Navbar,
    "web-footer": Footer
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#process-area {
  margin: 50px;
  padding-bottom: 40px;
  font-family: inherit;
  background-color: rgba(255, 255, 255, 0.904);
}

#banner-area {
  background-image: url("https://www.newsbtc.com/wp-content/uploads/2019/07/bitcoin-price-gold-crypto-shutterstock_742063846.jpg");
  background-size: cover;
  padding-bottom: 850px;
}

#banner-content {
  padding-top: 100px;
  color: #ffff;
}

.registerPart {
  background-color: #d6d6d6;
  width: 500px;
  height: 400px;
  border: #888888 2px solid;
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
