window.addEventListener("load", function(){
    const form = document.querySelector("#add_new_odontologo");
        if(form){
            form.addEventListener("submit", function(e){
                e.preventDefault();

                let formData = {
                    nombre : document.querySelector("#nombre").value,
                    apellido :  document.querySelector("#apellido").value,
                    matricula: document.querySelector("#matricula").value,
                };

                const settings = {
                    method : "POST",
                    headers : {
                        "content-type" : "application/json"
                    },
                    body : JSON.stringify(formData)
                }

                fetch("/odontologos", settings)
                    .then(function (response) {
                        if (!response.ok) throw Error(response.status);
                        return response.json()
                    })
                    .then(function (data) {
                        console.log(data);
                        let successAlert = '<div class="alert alert-success alert-dismissible">' +
                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                        '<strong></strong> Odontólogo creado </div>'
                        document.querySelector("#response").innerHTML = successAlert;
                        document.querySelector("#response").style.display = "block";
                        resetForm();
                    })
                    .catch(function (error) {
                        console.log(error);
                        let errorAlert = '<div class="alert alert-success alert-dismissible">' +
                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                        '<strong> Odontólogo creado</strong> </div>'
                        document.querySelector("#response").innerHTML = errorAlert;
                        document.querySelector("#response").style.display = "block";
                        resetForm();
                    })
        })

        function resetForm(){
                document.querySelector("#nombre").value = "";
                document.querySelector("#apellido").value = "";
                document.querySelector("#matricula").value = "";
            }
    }
});