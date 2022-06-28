$(function(){
    $('.slider_inner').slick({
        nextArrow: '<button type="button" class="slick-btn slick-next"></button>',
        prevArrow: '<button type="button" class="slick-btn slick-prev"></button>',
        infinite: false
    });
    $('.header_btn-menu').on('click',function (){
       $('.menu ul').slideToggle();
    });

});