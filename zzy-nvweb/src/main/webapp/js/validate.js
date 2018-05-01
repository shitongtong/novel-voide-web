!function (t) {
    var i = {
        errorRequired: "此项为必填项",
        errorTempl: '<span class="validate-error">{msg}</span>',
        optionTempl: '<span class="validate-option">{msg}</span>',
        callback: null
    }, r = ".item", s = ".validate-error", e = ".validate-option", a = function (t, i, r, s, e) {
        i && t && (this.asyncList = [], this.asyncEndHandle = null, this._init(t, i, r, s, e))
    };
    a.prototype = {
        _init: function (r, s, e, a, n) {
            var o;
            o = this.node = t(r), this.form = "form" === o[0].tagName.toLowerCase() ? o : o.find("form"), this.config = t.extend(i, n), this.rules = s, this.errorMsg = e || {}, this.optionMsg = a || {}, o.data("validateForm", this), this._bindEvent()
        }, _bindEvent: function () {
            this.node.data("hasBindValidateEvent") || (this.node.data("hasBindValidateEvent", !0), this.form.submit(t.proxy(function (t) {
                t.preventDefault(), this.validate(), this._handleFormSubmit()
            }, this)).find("input, select, textarea").bind({
                blur: t.proxy(function (t) {
                    this._handleBlur(t)
                }, this), focus: t.proxy(function (t) {
                    this._handleFocus(t)
                }, this)
            }), this._bindRules())
        }, _bindRules: function () {
            var i, r = this.rules;
            for (i in r)r.hasOwnProperty(i) && t(r[i].elems, this.form).each(function (r, s) {
                var e = t(s), a = e.data("validate-rules") || "";
                e.data("validate-rules", a + "," + i)
            })
        }, _handleBlur: function (i) {
            var s, a, n, o = t(i.target), l = o.parents(r).eq(0), h = o.data("validate-rules");
            if (l.find(e).hide(), h)for (h = h.split(",").slice(1), s = 0, n = h.length; s < n; s++)a = this.rules[h[s]], this.validate(a, this.errorMsg[h[s]], o)
        }, _handleFocus: function (i) {
            var r, s = i.target.getAttribute("name");
            s && (r = this.optionMsg[s.toLowerCase()]) && this.displayOptionMsg(t(i.target), r)
        }, _handleFormSubmit: function () {
            var i, r, s = this;
            return i = this.form.find(".has-error"), i.length > 0 ? void t(s.form).trigger("hasError") : (r = this.form.find(".has-process"), r.length > 0 ? void(this.asyncEndHandle = function () {
                s.asyncEndHandle = null, s._handleFormSubmit()
            }) : void(s.config.callback ? s.config.callback(s.form) : s.form[0].submit()))
        }, clearErrorMsg: function (t) {
            var i = t.parents(r).eq(0);
            i.find(s).hide()
        }, displayError: function (i, a) {
            var n = i.parents(r).eq(0), o = n.find(e), l = n.find(s);
            return o.hide(), 0 === l.length ? void t(this.config.errorTempl.replace("{msg}", a)).appendTo(n).show() : void l.show().html(a)
        }, displayOptionMsg: function (i, s) {
            if (s) {
                var a = i.parents(r).eq(0), n = a.find(e), o = a.hasClass("has-error");
                if (!o)return 0 === n.length ? void t(this.config.optionTempl.replace("{msg}", s)).appendTo(a).show() : void n.show().html(s)
            }
        }, asyncValidate: function (i, r, s) {
            if (i && r) {
                var e = i.parent();
                e.hasClass("has-process") || (e.addClass("has-process"), this.asyncList.push(t.getJSON(r, t.proxy(function (t) {
                    var i = this.asyncList;
                    s && s(t), e.removeClass("has-process"), this.asyncList.pop(), 0 === i.length && this.asyncEndHandle && this.asyncEndHandle()
                }, this))), t("body").ajaxError(function () {
                    alert("远程验证失败！\n请稍候重试或将此问题反馈给我们(help@douban.com)")
                }))
            }
        }, validate: function (s, e, a) {
            var n, o, l, h, d = this.errorMsg.errorRequired, c = function (s, e, a, n) {
                var o, l = a.parents(r).eq(0), h = !1;
                if (s.isRequired && "" === t.trim(a.val()))n.displayError(a, d || i.errorRequired), h = !0, l.addClass("has-error"); else {
                    for (o in s)if (s.hasOwnProperty(o) && "function" == typeof s[o] && s[o](a, n)) {
                        n.displayError(a, e[o]), l.addClass("has-error"), h = !0;
                        break
                    }
                    h || (n.clearErrorMsg(a), l.removeClass("has-error"))
                }
            };
            if (s)c(s, e, a, this); else {
                o = this.rules, l = this.errorMsg;
                for (h in o)o.hasOwnProperty(h) && (n = o[h], t(n.elems, this.form).each(t.proxy(function (i, r) {
                    c(n, l[h], t(r), this)
                }, this)))
            }
        }
    }, t.extend({
        validate: {
            isEmail: function (t) {
                return /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test(t)
            }
        }
    }), t.fn.validateForm = function (t, i, r, s) {
        var e = r, n = s;
        return 3 === arguments.length && (e = null, n = r), this.each(function () {
            new a(this, t, i, e, n)
        }), this
    }
}(jQuery);