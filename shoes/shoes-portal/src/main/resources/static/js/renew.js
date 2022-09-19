let renew = new Vue({
    el: '#renew',
    data:{
        username:'',
        phone:'',
        password:''
    },
    methods:{
        renew:function () {
            let data = {
                username: this.username,
                phone: this.phone,
                password: this.password
            }
            console.log(data);

            $.ajax({
                url: '/shoes/renew',
                method: 'POST',
                data: data,
                success: function (r) {
                    console.log(r);
                    if(r.code === CREATED) {
                        console.log("更新成功!");
                        console.log(r.message);
                        location.href = '/shoes/login_shoes.html?renew';
                    } else {
                        console.log("更新失敗!");
                        console.log(r.message);
                    }
                }
            });
        }
    }
});