$("#form").validate({
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
            required:"Please enter your City name !!!",
            minlength:"Minimum length of 5 characters !!",
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
