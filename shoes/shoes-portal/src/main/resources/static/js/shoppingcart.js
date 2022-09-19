let shoppingcart = new Vue({
    el: '#shoppingcart',
    data:{
        shoppingCarts: [],
        shoppingCartEmpty: false
    },
    methods: {
        loadshoppingCart: function () {
            console.log("開始下載購物車");
            let _this = this;
            $.ajax({
                url: '/shoes/shoppingcart',
                method: 'GET',
                success: function (r) {
                    console.log(r);
                    if(r.code === OK) {
                        console.log("下載成功");
                        console.log(r);
                        _this.shoppingCarts = r.data;
                        _this.loadImage();
                        _this.updateTotal();
                    }
                }
            });
        },
        loadImage: function () {
            let shoppingCarts = this.shoppingCarts;
            for(let i=0; i<shoppingCarts.length; i++) {
                let shoesImage = "/shoes/image/ACG Air Mada.png";
                let shoesName = shoppingCarts[i].shoesName;
                if(shoesName) {
                    shoesImage = "/shoes/image/" +shoesName+ ".png";
                }
                shoppingCarts[i].image = shoesImage;
            }
        },
        updateTotal: function () {
            let shoppingCarts = this.shoppingCarts;
            let total = 0;
            for(let i=0; i<shoppingCarts.length; i++) {
                let price = shoppingCarts[i].price;
                total = total+price;
            }
            $("#all").text("$"+total);
            $("#total").text("$"+total);

        },
        remove: function (shoppingCartShoesName,size) {
            console.log(shoppingCartShoesName+','+size);
            let data = {
                shoesName: shoppingCartShoesName,
                size: size
            }
            $.ajax({
                url: '/shoes/shoppingcart/remove',
                method: 'GET',
                data: data,
                success: function (r) {
                    console.log(r);
                    if(r.code === OK) {
                        console.log("刪除成功");
                        console.log(r.message);
                    }
                }
            });
            $('#removeShoes').remove();
            window.location.reload();
        }
    },
    created:function () {
        this.loadshoppingCart();
    }
});
