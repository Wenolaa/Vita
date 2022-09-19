let register_shoes = new Vue({
    el: '#register_shoes',
    data:{
        username:'',
        password:'',
        confirm:'',
        birthday:'',
        email:'',
        phone:'',
        message:'',
        hasError: false
    },
    methods:{
        register_shoes:function () {
            let data = {
                username: this.username,
                password: this.password,
                confirm: this.confirm,
                birthday: this.birthday,
                email: this.email,
                phone: this.phone
            }
            console.log(data);
            if(data.password !== data.confirm) {
                this.message = "密碼不一致!";
                this.hasError = true;
                return;
            }

            let _this = this;
            $.ajax({
                url: '/shoes/register_shoes',
                method: 'POST',
                data: data,
                success: function (r) {
                    console.log(r);
                    if(r.code === CREATED) {
                        console.log("註冊成功!");
                        console.log(r.message);
                        _this.hasError = false;
                        location.href = '/shoes/login_shoes.html?register_shoes';
                    } else {
                        _this.hasError = true;
                        console.log(r.message);
                        _this.message = r.message;
                    }
                }
            });
        }
    }
});