<script>
import api from "./api/api.js";

export default {
  data() {
    return {
      student: null,
      reviews: [],
      shortDescription: '',
      errorMessage: ''
    };
  },
  methods: {
    async fetchStudent(studentId) {
      try {
        const response = await api.get(`/authorized/student/${studentId}`);
        this.student = response.data;
      } catch (error) {
        this.errorMessage = 'Ошибка при загрузке данных студента';
      }
    },
    async fetchReviews() {
      try {
        const studentId = this.$route.params.id; // Получаем id студента из маршрута
        const response = await api.get(`/authorized/reviewByStudentId?id=${studentId}`); // Используем полученный id для запроса отзывов
        this.reviews = response.data; // Наполняем массив отзывов полученными данными
      } catch (error) {
        this.errorMessage = 'Ошибка при загрузке отзывов';
      }
    },
    async submitFeedback() {
      try {
        const newReview = {
          student: {
            studentId: Number(this.$route.params.id),
          },
          shortDescription: this.shortDescription, 
        };
        if (this.shortDescription.length === 0) {
          this.errorMessage = 'Пустое поле по отправке отзыва';
        } else {
          await api.post(`/authorized/new/review`, newReview);
          alert('Отзыв успешно отправлен');
          this.reviews.push(newReview);
        }
      } catch (error) {
        this.errorMessage = 'Ошибка при отправке отзыва';
      }
    }
  },
  async mounted() {
    try {
      const studentId = this.$route.params.id;
      await this.fetchStudent(studentId);
      await this.fetchReviews();
    } catch (error) {
      this.errorMessage = 'Ошибка при инициализации данных';
    }
  },
};
</script>

<!-- html -->
<template>
    <header>
      <div class="logo">
        <a href="/home"><img src="C:\Users\Admin\Downloads\NoteHub\vue-project\src\assets\logo.png" height="100px"></a>
      </div>
      <nav>
        <ul class="nav">
          <li><a href="/auth/home">Личный кабинет</a></li>
          <li><a href="/auth/StudProf">Поиск студента</a></li>
          <li><a href="">Выход</a></li>
        </ul>
      </nav>
    </header>
    
    <main>
      <div class="page">
        <h1>Студент</h1>
        <div v-if="student" class="student-details">
          <img :src="student.photoLink" alt="Фото студента" height="150px">
          <p>Имя: {{ student.firstName }}</p>
          <p>Фамилия: {{ student.lastName }}</p>
          <p>Отчество: {{ student.patronymic }}</p>
          <p>Возраст: {{ student.age }}</p>
          <p>Email: {{ student.email }}</p>
          <p>Телефон: {{ student.phoneNumber }}</p>
          <p>Группа: {{ student.group.groupName }}</p>
          <p>Специализация: {{ student.specialization.specializationName }}</p>
          <p>Родитель: {{ student.parent }}</p>
        </div>
        <div v-else>
          <p>Загрузка данных студента...</p>
        </div>
        
        <div class="feedback-section">
          <h2>Оставить отзыв</h2>
          <input type="text" v-model="shortDescription" placeholder="Напишите свой отзыв здесь..."></input>
          <button @click="submitFeedback">Отправить отзыв</button>
          <p v-if="errorMessage" class="error-message">{{ errorMessage }}</p>
        </div>
        <div>Отзывы</div>
        
        <div v-if="reviews.length">
          <ul>
            <li v-for="review in reviews">{{review.shortDescription}}</li>
          </ul>
        </div>
      </div>
    </main>

  <footer class="footer-distributed">

<div class="footer-left">

  <h3>NoteHub</h3>

  <p class="footer-links">
    <a href="" class="link-1"></a>

    <a href=""></a>

    <a href=""></a>

    <a href=""></a>

  </p>

  <p class="footer-company-name">NoteHub © 2024</p>
</div>

<div class="footer-center">

  <div>
    <i class="fa fa-map-marker"></i>
    <p class="tx1"></p>
  </div>

  <div>
    <i class="fa fa-phone"></i>
    <p class="tx1"></p>
  </div>

  <div>
    <i class="fa fa-envelope"></i>
    <p class="tx1"><a class="a" href=""></a></p>
  </div>

</div>

<div class="footer-right">
  <div class="footer-icons">
    <a href=""><i class="fa fa-twitter"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 64 64" width="64px"
          height="64px">
          <linearGradient id="EEzBmxT86u8E~6vCqQtLma" x1="29.5" x2="29.5" y1="19.006" y2="46"
            gradientUnits="userSpaceOnUse" spreadMethod="reflect">
            <stop offset="0" stop-color="#6dc7ff" />
            <stop offset="1" stop-color="#e6abff" />
          </linearGradient>
          <path fill="url(#EEzBmxT86u8E~6vCqQtLma)"
            d="M22.007,35.25L39.022,25L27.011,37.5l10.535,8.275c1.887,0.83,2.574-0.899,2.574-0.899 l4.825-24.501c0,0,0.082-0.625,0.045-0.75c-0.344-1.168-2.228-0.325-2.227-0.324L15.206,30.188c0,0-1.304,0.449-1.201,1.278 c0.103,0.83,1.167,1.209,1.167,1.209l6.837,2.575" />
          <linearGradient id="EEzBmxT86u8E~6vCqQtLmb" x1="29.5" x2="29.5" y1="5.833" y2="58.262"
            gradientUnits="userSpaceOnUse" spreadMethod="reflect">
            <stop offset="0" stop-color="#1a6dff" />
            <stop offset="1" stop-color="#c822ff" />
          </linearGradient>
          <path fill="url(#EEzBmxT86u8E~6vCqQtLmb)"
            d="M45.949,19.343c-0.23-0.784-0.859-1.269-1.727-1.33c-0.175-0.013-1.159,0.027-1.823,0.365 l-0.003-0.007L14.881,29.243C13.996,29.547,13.02,30.266,13,31.33c-0.002,0.084,0.003,0.171,0.014,0.26 c0.173,1.4,1.654,1.968,1.807,2.021l6.377,2.402c0.49,1.575,2.108,6.774,2.456,7.886c0.234,0.744,0.62,1.709,1.327,1.973 C25.185,45.956,25.402,46,25.628,46c0.614,0,1.014-0.312,1.163-0.447l3.903-3.89l6.235,4.897c0.065,0.052,0.138,0.096,0.215,0.129 c0.517,0.228,0.976,0.31,1.367,0.31c0.409,0,0.745-0.089,0.998-0.193c1.067-0.438,1.494-1.447,1.54-1.561 c0.022-0.057,0.04-0.116,0.052-0.176l4.835-24.564C46.047,19.669,45.987,19.472,45.949,19.343z M23.195,35.701l9.872-5.947 l-6.775,7.053c-0.12,0.124-0.188,0.279-0.229,0.442c-0.003,0.012-1.006,4.43-1.006,4.43L23.195,35.701z M43.963,20.188l-4.799,24.37 c-0.057,0.098-0.2,0.311-0.413,0.398c-0.179,0.073-0.412,0.055-0.694-0.053l-9.559-7.507l11.245-11.704 c0.348-0.361,0.374-0.925,0.061-1.316c-0.312-0.391-0.867-0.491-1.297-0.232l-16.601,10l-6.389-2.406 c-0.196-0.075-0.398-0.221-0.481-0.323c0.109-0.096,0.329-0.221,0.537-0.296L43.131,20.23c0.017-0.006,0.033-0.014,0.05-0.021 c0.251-0.11,0.59-0.192,0.803-0.205C43.974,20.104,43.963,20.187,43.963,20.188z" />
          <linearGradient id="EEzBmxT86u8E~6vCqQtLmc" x1="32" x2="32" y1="5.833" y2="58.262"
            gradientUnits="userSpaceOnUse" spreadMethod="reflect">
            <stop offset="0" stop-color="#1a6dff" />
            <stop offset="1" stop-color="#c822ff" />
          </linearGradient>
          <path fill="url(#EEzBmxT86u8E~6vCqQtLmc)"
            d="M32,58C17.663,58,6,46.336,6,32S17.663,6,32,6s26,11.664,26,26S46.337,58,32,58z M32,8 C18.767,8,8,18.767,8,32s10.767,24,24,24s24-10.767,24-24S45.233,8,32,8z" />
        </svg></i></a>
    <a href=""><i class="fa fa-linkedin"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 64 64" width="64px"
          height="64px" fill-rule="evenodd" clip-rule="evenodd">
          <linearGradient id="fzF5K76u~QPjMIgETt7bMa" x1="32" x2="32" y1="5.25" y2="58.834"
            gradientUnits="userSpaceOnUse" spreadMethod="reflect">
            <stop offset="0" stop-color="#1a6dff" />
            <stop offset="1" stop-color="#c822ff" />
          </linearGradient>
          <path fill="url(#fzF5K76u~QPjMIgETt7bMa)"
            d="M6.399,57.699l3.792-13.847c-2.076-3.74-3.17-7.975-3.168-12.272 C7.028,17.641,18.373,6.301,32.312,6.301c6.762,0.003,13.115,2.636,17.889,7.414c4.774,4.778,7.402,11.151,7.4,17.944 C57.595,45.633,46.25,57,32.312,57c-4.024,0-8.073-1.019-11.744-2.95L6.399,57.699z M20.828,51.918l0.346,0.188 C24.645,53.999,28.492,55,32.302,55c12.846,0,23.293-10.471,23.299-23.341c0.002-6.26-2.418-12.13-6.814-16.53 S38.538,8.304,32.312,8.301c-12.836,0-23.283,10.443-23.288,23.279c-0.002,4.089,1.072,8.113,3.107,11.639l0.209,0.361L9.239,54.902 L20.828,51.918z M32.312,53c-3.686,0-7.415-1.06-10.793-3.063l-0.437-0.318l-8.854,2.323l2.382-8.691l-0.244-0.387 c-2.123-3.376-3.243-7.271-3.241-11.269c0.004-11.67,9.513-21.165,21.195-21.165c5.642,0.002,10.961,2.218,14.979,6.239 c4,4.003,6.202,9.345,6.2,15.039C53.495,43.448,43.99,53,32.312,53z M22.583,48.242C25.641,50.047,29.001,51,32.304,51 c10.584,0,19.191-8.654,19.195-19.292c0.002-5.161-1.992-10-5.614-13.625c-3.642-3.644-8.459-5.651-13.565-5.653 c-10.581,0-19.191,8.598-19.195,19.166c-0.002,3.619,1.012,7.146,2.933,10.201l0.715,1.131l-1.698,6.199l6.429-1.687L22.583,48.242z" />
          <linearGradient id="fzF5K76u~QPjMIgETt7bMb" x1="32.305" x2="32.305" y1="17.5" y2="46.527"
            gradientUnits="userSpaceOnUse" spreadMethod="reflect">
            <stop offset="0" stop-color="#6dc7ff" />
            <stop offset="1" stop-color="#e6abff" />
          </linearGradient>
          <path fill="url(#fzF5K76u~QPjMIgETt7bMb)" fill-rule="evenodd"
            d="M26.12,21.219c-0.464-1.031-0.952-1.052-1.394-1.07 c-0.361-0.015-0.774-0.015-1.187-0.015c-0.413,0-1.084,0.155-1.651,0.775c-0.568,0.62-2.168,2.118-2.168,5.164 c0,3.047,2.219,5.991,2.529,6.405c0.31,0.413,4.284,6.865,10.579,9.347c5.231,2.063,6.296,1.653,7.431,1.549 c1.135-0.103,3.664-1.498,4.18-2.944c0.516-1.446,0.516-2.685,0.361-2.944c-0.155-0.258-0.568-0.413-1.187-0.723 c-0.619-0.31-3.664-1.808-4.232-2.014c-0.568-0.206-0.981-0.31-1.394,0.31c-0.413,0.619-1.599,2.014-1.96,2.427 c-0.361,0.414-0.723,0.465-1.342,0.156c-0.619-0.311-2.614-0.964-4.98-3.074c-1.841-1.641-3.084-3.668-3.445-4.288 c-0.361-0.619-0.039-0.955,0.272-1.264c0.278-0.277,0.619-0.723,0.929-1.085c0.309-0.362,0.412-0.62,0.619-1.033 c0.206-0.414,0.103-0.775-0.052-1.085S26.67,22.443,26.12,21.219z"
            clip-rule="evenodd" />
        </svg></i></a>
    <a href="https://vk.com/feed"><i class="fa fa-github"><svg xmlns="http://www.w3.org/2000/svg"
          viewBox="0 0 64 64" width="64px" height="64px">
          <linearGradient id="kgRuRVfhYbsg7F4Xxd2wXa" x1="32" x2="32" y1="-1703.5" y2="-1757.251"
            gradientTransform="matrix(1 0 0 -1 0 -1698)" gradientUnits="userSpaceOnUse">
            <stop offset="0" stop-color="#1a6dff" />
            <stop offset="1" stop-color="#c822ff" />
          </linearGradient>
          <path fill="url(#kgRuRVfhYbsg7F4Xxd2wXa)"
            d="M32,58C17.664,58,6,46.337,6,32S17.664,6,32,6s26,11.663,26,26S46.336,58,32,58z M32,8 C18.767,8,8,18.767,8,32s10.767,24,24,24s24-10.767,24-24S45.233,8,32,8z" />
          <linearGradient id="kgRuRVfhYbsg7F4Xxd2wXb" x1="31" x2="31" y1="-1721.333" y2="-1741.616"
            gradientTransform="matrix(1 0 0 -1 0 -1698)" gradientUnits="userSpaceOnUse">
            <stop offset="0" stop-color="#6dc7ff" />
            <stop offset="1" stop-color="#e6abff" />
          </linearGradient>
          <path fill="url(#kgRuRVfhYbsg7F4Xxd2wXb)"
            d="M40.975,32.906c0,0,3.974-5.822,4.369-7.664C45.477,24.584,45.188,24,44.502,24 c0,0-2.29,0-3.448,0c-0.79,0-1.079,0.558-1.316,1.058c0,0-1.864,4.08-4.132,6.583c-0.728,0.809-0.914,1.107-1.316,1.107 c-0.324,0-0.29-0.216-0.29-0.946v-6.396C34,24.51,33.528,24,32.791,24h-5.527c-0.421,0-0.618,0.368-0.618,0.702 c0,0.843,1.356,1.156,1.356,3.44v4.711c0,0.948-0.119,1.316-0.566,1.316c-1.184,0-4.034-4.203-5.613-8.836 C21.505,24.387,21.13,24,20.236,24h-3.448c-0.5,0-0.869,0.466-0.869,0.966c0,0.921,1.079,5.247,5.317,10.959 c2.843,3.843,6.711,5.953,10.08,5.953c2.053,0,2.684-0.311,2.684-1.18V37.75c0-0.737,0.158-1.053,0.579-1.053 c0.474,0,1.244,0.198,3.198,2.125C40.095,41.033,40.187,42,41.45,42h3.869c0.395,0,0.763-0.23,0.763-0.888 c0-0.869-1.132-2.444-2.869-4.287c-0.711-0.947-1.869-1.985-2.237-2.459C40.45,33.813,40.607,33.485,40.975,32.906z" />
        </svg></i>
    </a>

  </div>
</div>
</footer>
</template>





<style scoped>
/* Reset some default styles */
body, html {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: Arial, sans-serif;
}

/* Ensure the header and footer span the full width of the screen */
header, footer {
  width: 100%;
}

/* Header styling */
header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px 20px;
  background-color: #333;
  color: #fff;
}

.logo img {
  height: 100px;
}

nav ul.nav {
  list-style: none;
  display: flex;
  gap: 20px;
  padding: 0;
  margin: 0;
}

nav ul.nav li a {
  color: #fff;
  text-decoration: none;
}

nav ul.nav li a:hover {
  text-decoration: underline;
}

/* Main content styling */
main {
  display: flex;
  justify-content: center;
  align-items: center;
  height: calc(100vh - 160px); /* Adjust based on header and footer height */
  background-color: #f4f4f4;
  padding: 20px;
}

.reg_window {
  background-color: #fff;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 0 10px rgba(0,0,0,0.1);
  max-width: 400px;
  width: 100%;
}

.reg_input h2 {
  margin-bottom: 20px;
}

.reg_input p {
  margin-bottom: 10px;
}

.reg_input label {
  display: block;
  margin-bottom: 5px;
}

.reg_input input {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.error-message {
  color: red;
  font-size: 0.875em;
  margin-top: 5px;
}

.reg_Button {
  margin-top: 20px;
}

.regBT {
  width: 100%;
  padding: 10px;
  background-color: #333;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.regBT:hover {
  background-color: #555;
}

/* Footer styling */
.footer-distributed {
  display: flex;
  justify-content: space-between;
  padding: 20px;
  background-color: #333;
  color: #fff;
  width: 100%;
  box-sizing: border-box;
}

.footer-left, .footer-center, .footer-right {
  width: 30%;
}

.footer-links {
  list-style: none;
  padding: 0;
}

.footer-links a {
  color: #fff;
  text-decoration: none;
}

.footer-links a:hover {
  text-decoration: underline;
}

.footer-icons {
  display: flex;
  gap: 10px;
}

.footer-icons a {
  color: #fff;
  text-decoration: none;
}

.footer-company-name {
  margin-top: 10px;
}

.footer-company-name, .tx1, .a {
  font-size: 0.875em;
}

.tx1 a, .a {
  color: #fff;
  text-decoration: none;
}

.tx1 a:hover, .a:hover {
  text-decoration: underline;
}
</style>