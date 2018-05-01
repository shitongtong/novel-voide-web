
$(function(){
    var intro_form = $('form[name="edit_intro"]')[0];
    var intro_error = $('#intro_error');
    var intro_disp = $('#intro_display');
    var intro_action = $('#intro_disp_act');
    var intro_action_a = $('#intro_disp_act a');
    var intro_textarea = $('textarea[name="intro"]');
    var intro_submit = $('#intro_submit');
    var intro_cancel = $('#intro_cancel');

    var introShow = function(t){
            if(t != undefined){
                intro_disp.html(t);
                if (intro_disp.text() === ''){
                    intro_action_a.text('添加自我介绍');
                }else{
                    intro_action_a.text('编辑');
                };
            }
            $(intro_form).hide();
            intro_disp.show();
            intro_action.show();
            intro_error.css('display', 'none');
        }

    var myEnableForm = function(){
        $(intro_form).attr('disabled', 0);
        $(intro_form).children('input,textarea').attr('disabled', 0);
        intro_textarea.focus();
    }

    intro_textarea.elastic();

    $(intro_form).submit(function(e){
        e.preventDefault();
        remote_submit_json(intro_form, function(r){
            if (r.r === '0') {
                introShow( r.intro );
                intro_error.css('display', 'none');
                intro_disp.css('font-style', 'normal');
            } else {
                intro_error.text(r.error);
                intro_error.css('display', 'inline');
                myEnableForm();
            }
        });
        return false;
    });

    intro_cancel.click(function(e){
        e.preventDefault();
        $(intro_form).hide();
        intro_disp.show();
        intro_action.show();
        intro_error.css('display', 'none');
    });

    intro_action_a.click(function(e){
        e.preventDefault();
        intro_disp.hide();
        intro_action.hide();
        $(intro_form).show();

        myEnableForm();
        intro_textarea.elastic();
    });

    $('.medal').each(function() {
        var timer = 0;
        $(this).hover(function() {
            clearTimeout(timer);
            $('.medal-bd').css('zIndex', 2);
            $(this).find('.medal-bd').show()
                                     .css('zIndex', 10);
        }, function() {
            var $this = $(this);
            timer = setTimeout(function() {
                $this.find('.medal-bd').fadeOut();
            }, 500);
        });
    });

});
