let payment = new Vue({
    el: '#payment',
    data:{
        username:'',
        address:'',
        phone:'',
        email:'',
        cardName:'',
        cardNumber:'',
        cardNumber1:'',
        cardNumber2:''
    },
    methods:{
        payment:function () {
            let data = {
                username: this.username,
                address: this.address,
                phone: this.phone,
                email: this.email,
                cardName: this.cardName,
                cardNumber: this.cardNumber,
                cardNumber1: this.cardNumber1,
                cardNumber2: this.cardNumber2
            }
            console.log(data);

            $.ajax({
                url: '/shoes/payment',
                method: 'POST',
                data: data,
                success: function (r) {
                    console.log(r);
                    if(r.code === CREATED) {
                        console.log("下單成功!");
                        console.log(r.message);
                    } else {
                        console.log(r.message);
                    }
                }
            });
        }
    }
});