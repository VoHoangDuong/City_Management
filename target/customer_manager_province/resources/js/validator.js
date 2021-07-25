$("#form-create").validate({
    rules: {
        name: {
            required: true,
            minlength: 5,
        },
        country: {
            required: true,
        },
        acreage: {
            required: true,
            min: 5,
        },
        population: {
            required: true,
            min: 1,
        },
        GDP: {
            required: true,
            min: 5,
        },
        description: {
            required: true,
            minlength: 5,
            maxlength: 50,
        },
    },

    messages: {
        name: {
            required: (("#FF0000")+("Please enter your City name !!!")),
            minlength:"Minimum length of 5 characters !!"
        },
        country: {
            required: "Please choose a country !!",
        },
        acreage: {
            required: "Please enter the area !!",
            min: "Area greater than 5 and other than 0 !!"
        },
        population: {
            required: "Please enter the population !!",
            min: "Population greater than 1 !!"
        },
        GDP: {
            required: "Please enter the GDP !!",
            min: "Population greater than 5 !!"
        },
        description: {
            required: "Please enter the description !!",
            minlength: "Minimum length of 5 characters !!",
            maxlength: "Maximum length 50 characters !!"
        },
    },
    submitHandler: function(form) {
        form.submit();
    }
});

$.validator.addMethod("validatePassword", function (value, element) {
    return this.optional(element) || /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$/i.test(value);
}, "Hãy nhập password từ 8 đến 16 ký tự bao gồm chữ hoa, chữ thường và ít nhất một chữ số");