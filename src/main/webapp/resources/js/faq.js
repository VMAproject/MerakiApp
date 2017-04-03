/**
 * Created by oleksandr on 24.03.17.
 */
$(document).ready(function(){
    PopUpHide();
});

function PopUpHide() {
    $('#popup1').hide();
}

function PopUpToggle() {
    $('#popup1').toggle();
    var vista = $("#WindowsVista");
    var popup = $("#popup1");
    if(vista.is((':visible'))) {
        var topPos = vista.position().top;
        setInterval(stickIt, 10);
        function stickIt() {
            var top = vista.offset().top;
            if (top<=0) {
                var scrlTop = popup.scrollTop();
                vista.addClass('sticking');
                if(topPos > scrlTop) {
                    vista.removeClass('sticking');
                }
            }
        }
    }
}
