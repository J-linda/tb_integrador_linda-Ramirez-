function editarPaciente(){
    document.querySelector('#btn-update-paciente').addEventListener('click', function(e){

        const settingsPaciente = {
            method : "PUT",
            headers : {
               "content-type" : "application/json",
            },
            body : JSON.stringify({
               "id" : document.querySelector("#id-paciente").value,
               "nombre" : document.querySelector("#nombre").value,
               "apellido" :  document.querySelector("#apellido").value,
               "dni": document.querySelector("#dni").value,
            })
        }

        fetch(('/pacientes'), settingsPaciente)
                .then(response => {
                   console.log(response.status);
                })

        const settingsDomicilio = {
            method : "PUT",
            headers : {
               "content-type" : "application/json",
            },
            body : JSON.stringify({
                "id" : document.querySelector("#id-domicilio").value,
                "calle" : document.querySelector("#calle").value,
                "numero" :  document.querySelector("#numero").value,
                "localidad": document.querySelector("#localidad").value,
                "provincia": document.querySelector("#provincia").value,
            })
        }

        fetch(('/domicilios'), settingsDomicilio)
                .then(response => {
                   console.log(response.status);
                })

        mostrarTodos();
    })
}