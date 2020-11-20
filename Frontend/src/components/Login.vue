<template>
  <div >
    用户名:<input type="text" v-model="id" placeholder="请输入账号" />
    <br><br>
    密码:<input type="password" v-model="password" placeholder="请输入密码" />
    <br><br>
    <button @click="login">登录</button>
    <br><br>

    <router-link to='/Register'>
      <span style="text-align:center;font-size: 14px;">账号注册</span>
    </router-link>

    <router-link to='/ChangePwd'>
      <span style="text-align:center;font-size: 14px; color:red;">修改密码</span>
    </router-link>
  </div>
</template>

<script  type="application/ecmascript">
  import * as types from '../store/types'
  import api from '../api'
  export default {
    name:"login",
    data() {
      return {
        id: "",
        password: "",
      }
    },
    methods:{
       login(){
           let data1={id:this.id,password:this.password}
           this.$store.commit(types.LOGIN, data1);
            this.axios.get(api.login+"?id="+this.id+"&password="+this.password)
            .then(response => {
            if (response.data.code === 102) 
            {
            this.$router.push({path: '/Home'})
            } 
          else {
              console.log("login fail")
          }
        })
    }
 }
}
</script>