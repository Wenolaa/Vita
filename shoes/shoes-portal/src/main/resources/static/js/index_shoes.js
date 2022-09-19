let index_shoes = new Vue({
    el: '#index_shoes',
    data: {
        shoesDetails: [],
        cur_size:0
    },
    methods: {
        loadShoesDetail: function () {
            console.log("開始載入首頁");
            let _this = this;
            $.ajax({
                url: '/shoes/index_shoes',
                method: 'GET',
                success: function (r) {
                    console.log(r);
                    if (r.code === OK) {
                        console.log("下載成功");
                        console.log(r);
                        _this.shoesDetails = r.data;
                        _this.loadImages();
                    }
                }
            });
        },
        loadImages: function () {
            let shoesDetails = this.shoesDetails;
            for(let i=0; i<shoesDetails.length; i++) {
                let shoesImage = "/shoes/image/ACG Air Mada.png";
                let shoesName = shoesDetails[i].shoesName;
                if(shoesName) {
                    shoesImage = "/shoes/image/" +shoesName+ ".png";
                }
                shoesDetails[i].image = shoesImage;
            }
        },
        checkSize: function (size) {
            this.cur_size = size
        },
        addShoes: function (shoesName, price) {
            console.log(shoesName+","+price);
            let data = {
                shoesName: shoesName,
                price: price,
                size: this.cur_size
            }
            console.log(data)
            $.ajax({
                url: '/shoes/index_shoes/add',
                method: 'GET',
                data: data,
                success: function (r) {
                    console.log(r);
                    if(r.code === CREATED) {
                        console.log("加入成功");
                        console.log(r.message);
                    }
                }
            });
        }
    },
    created:function () {
        this.loadShoesDetail();
    }
});