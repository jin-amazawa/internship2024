$(document).ready(function() {
    // メニューにホバーしたときの動作
    $(".menu > li").hover(
        function() {
            // サブメニューをスライドダウンで表示
            $(this).find(".submenu").stop().slideDown(300);
        },
        function() {
            // サブメニューをスライドアップで非表示
            $(this).find(".submenu").stop().slideUp(300);
        }
    );
});



$(document).ready(function() {
    let currentSlide = 0;
    const slides = $(".slide");
    const totalSlides = slides.length;

    // 最初のスライドを表示
    $(slides[currentSlide]).fadeIn(1000);

    // スライドを切り替える関数
    function showNextSlide() {
        $(slides[currentSlide]).fadeOut(1000,function(){
            // 現在のスライドをフェードアウト
            currentSlide = (currentSlide + 1) % totalSlides; // 次のスライドのインデックスを計算
            $(slides[currentSlide]).fadeIn(1000); // 次のスライドをフェードイン
        }); 
    }

    // 3秒ごとにスライドを切り替え
    setInterval(showNextSlide, 3000);
});