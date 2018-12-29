let imgArray = [];//用于存放需要改变的img标签
let twinkleArray = [];//时间分割符闪烁
window.onload = function () {
    //获取时钟所在div容器
    const oClock = document.getElementById('clock');
    //获取时钟所有img标签
    const oImg = oClock.getElementsByTagName('img');
    let lenOImg = oImg.length;
    // alert(lenOImg)
    for (let i = 0; i < lenOImg; i++) {
        if (i === 0 || i === 5 || i === 8 || i === 11 || i === 20) {//时钟标题及年月日、星期不变等文字不变
            continue;
        }
        if (i === 14 || i === 17) {
            twinkleArray.push(oImg[i]);//两个冒号
            continue;
        }

        // oImg[i].src = "./images/clock/0.png";

        imgArray.push(oImg[i]);

    }
    setInterval(updateDate, 1000);

};

/**
 * 动态更新时间
 */
function updateDate() {
    // alert(twinkleArray[0].style.display);
    /*
    * 冒号分割
    * display:none;不占位隐藏
    * visibility:hidden;占位隐藏
    * */
    if (twinkleArray[0].style.visibility === "hidden") {
        twinkleArray[0].style.visibility = ''
    } else {
        twinkleArray[0].style.visibility = 'hidden'
    }
    if (twinkleArray[1].style.visibility === 'hidden') {
        twinkleArray[1].style.visibility = ''
    } else {
        twinkleArray[1].style.visibility = 'hidden'
    }
    //获取当期日期及时间
    let imgArrayLen = imgArray.length;
    // alert(imgArrayLen);
    // for (let i = 0; i < imgArrayLen; i++) {
    //     alert(imgArray[i].src);
    // }
    const oDate = new Date();
    // alert(oDate.getUTCFullYear());

    //处理年
    const y = String(oDate.getFullYear());//2018年份

    const yLen = y.length;//年份长度 4
    for (let i = 0; i < yLen; i++) {
        imgArray[i].src = "./images/clock/" + y.charAt(i) + ".png";//设置年份中的第 i个
    }
    //处理月
    const m = String(oDate.getMonth());//月份-1
    const mLen = m.length;//月份长度 2
    // alert(mLen);
    if (mLen === 1) {//0~9
        let m0 = parseInt(m.charAt(0));
        if (m0 <= 8) {
            //0~8月(即1~9)
            imgArray[yLen].src = "./images/clock/0.png";//设置月份第一个img显示 0
            imgArray[yLen + 1].src = "./images/clock/" + (m0 + 1) + ".png";//设置月份中的第 2个 显示 m+1
        } else {
            //10月
            imgArray[yLen].src = "./images/clock/1.png";//设置月份第一个img显示 1
            imgArray[yLen + 1].src = "./images/clock/0.png";//设置月份中的第 2个显示 0
        }
    } else {
        let m1 = parseInt(m.charAt(1));
        imgArray[yLen].src = "./images/clock/1.png";//设置月份中的第 i个
        imgArray[yLen + 1].src = "./images/clock/" + (m1 + 1) + ".png";
    }

    //处理日
    const d = String(oDate.getDate());//几号
    const dLen = d.length;//日长
    if (dLen === 1) {//1-9
        let d0 = parseInt(d.charAt(0));
        imgArray[yLen + mLen].src = "./images/clock/0.png";//设置月份第一个img显示 0
        imgArray[yLen + mLen + 1].src = "./images/clock/" + d0 + ".png";//设置月份中的第 2个 显示 d0
    } else {//10-12
        imgArray[yLen + mLen].src = "./images/clock/" + d.charAt(0) + ".png";//设置月份第一个img显示 0
        imgArray[yLen + mLen + 1].src = "./images/clock/" + d.charAt(1) + ".png";//设置月份第一个img显示 0
    }
    //处理时
    const h = String(oDate.getHours());
    // alert(h);
    const hLen = h.length;
    if (hLen === 1) {//0-8(1-9)
        imgArray[yLen + mLen + dLen].src = "./images/clock/0.png";//设置月份第一个img显示 0
        let h1 = parseInt(h.charAt(0));
        if (h1 > 0) {
            imgArray[yLen + mLen + dLen + 1].src = "./images/clock/" + h1 + ".png";//设置月份中的第 2个 显示 d0
        } else {
            //00点
            imgArray[yLen + mLen + dLen + 1].src = "./images/clock/0.png";//设置月份中的第 2个显示 0
        }
    } else {//10-12
        imgArray[yLen + mLen + dLen].src = "./images/clock/" + h.charAt(0) + ".png";//设置月份第一个img显示 0
        imgArray[yLen + mLen + dLen + 1].src = "./images/clock/" + h.charAt(1) + ".png";//设置月份第一个img显示 0
    }
    //处理分
    const mf = String(oDate.getMinutes());
    // alert(mf);
    const mfLen = mf.length;
    if (mfLen === 1) {//0-8(1-9)
        imgArray[yLen + mLen + hLen + dLen].src = "./images/clock/0.png";//设置月份第一个img显示 0
        let mf1 = parseInt(mf.charAt(0));
        if (mf1 > 0) {
            imgArray[yLen + mLen + dLen + hLen + 1].src = "./images/clock/" + mf1 + ".png";//设置月份中的第 2个 显示 d0
        } else {
            //00点
            imgArray[yLen + mLen + dLen + hLen + 1].src = "./images/clock/0.png";//设置月份中的第 2个显示 0
        }
    } else {//10-12
        imgArray[yLen + mLen + dLen + hLen].src = "./images/clock/" + mf.charAt(0) + ".png";//设置月份第一个img显示 0
        imgArray[yLen + mLen + dLen + hLen + 1].src = "./images/clock/" + mf.charAt(1) + ".png";//设置月份第一个img显示 0
    }
    //处理秒
    const s = String(oDate.getSeconds());
    // alert(s);
    const sLen = s.length;
    if (sLen === 1) {//0-8(1-9)
        imgArray[yLen + mLen + dLen + hLen + mfLen].src = "./images/clock/0.png";//设置月份第一个img显示 0
        let s1 = parseInt(s.charAt(0));
        if (s1 > 0) {
            imgArray[yLen + mLen + dLen + hLen + mfLen + 1].src = "./images/clock/" + s1 + ".png";//设置月份中的第 2个 显示 d0
        } else {
            //00点
            imgArray[yLen + mLen + hLen + dLen + mfLen + 1].src = "./images/clock/0.png";//设置月份中的第 2个显示 0
        }
    } else {//10-59
        imgArray[yLen + mLen + dLen + hLen + mfLen].src = "./images/clock/" + s.charAt(0) + ".png";//设置月份第一个img显示 0
        imgArray[yLen + mLen + dLen + hLen + mfLen + 1].src = "./images/clock/" + s.charAt(1) + ".png";//设置月份第一个img显示 0
    }
    //处理周
    const w = oDate.getDay();//星期
    switch (w) {
        case 1:
            imgArray[imgArrayLen - 1].src = "./images/clock/one.png";//设置月份第一个img显示 0
            break;
        case 2:
            imgArray[imgArrayLen - 1].src = "./images/clock/two.png";//设置月份第一个img显示 0
            break;
        case 3:
            imgArray[imgArrayLen - 1].src = "./images/clock/three.png";//设置月份第一个img显示 0
            break;
        case 4:
            imgArray[imgArrayLen - 1].src = "./images/clock/four.png";//设置月份第一个img显示 0
            break;
        case 5:
            imgArray[imgArrayLen - 1].src = "./images/clock/five.png";//设置月份第一个img显示 0
            break;
        case 6:
            imgArray[imgArrayLen - 1].src = "./images/clock/six.png";//设置月份第一个img显示 0
            break;
        case 7:
            imgArray[imgArrayLen - 1].src = "./images/clock/seven.png";//设置月份第一个img显示 0
            break;
    }


}
