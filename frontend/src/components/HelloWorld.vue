<template>
  <div>
    <h2>아이템 등록</h2>
    <form @submit.prevent="submitForm">
      <div class="form-group">
        <label for="name">이름:</label>
        <input type="text" id="name" v-model="item.name" required>
      </div>
      <div class="form-group">
        <label for="price">가격:</label>
        <input type="number" id="price" v-model.number="item.price" required>
      </div>
      <div class="form-group">
        <label for="amount">수량:</label>
        <input type="number" id="amount" v-model.number="item.amount" required>
      </div>
      <div class="form-group">
        <label for="description">설명:</label>
        <textarea id="description" v-model="item.description"></textarea>
      </div>
      <div class="form-group">
        <label for="picture">사진:</label>
        <input type="file" id="picture" @change="onFileChange">
      </div>
      <button type="submit">등록</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      item: {
        name: '',
        price: null,
        amount: null,
        description: '',
        picture: null
      }
    };
  },
  methods: {
    onFileChange(event) {
      const file = event.target.files[0];
      this.item.picture = file;
    },
    async submitForm() {
      // 이 부분에서 아이템을 서버로 보내는 코드를 작성합니다. Axios 등의 HTTP 클라이언트를 사용할 수 있습니다.
      console.log(this.item);
      // 예를 들어, 아이템을 서버로 보내는 API 호출을 할 수 있습니다.
      // await axios.post('/api/items', this.item);
    }
  }
};
</script>
