window.addEventListener("load", function(){
    if(window.location.pathname == "/odontologos.html")
        mostrarTodos();
});

async function mostrarTodos(){

        await fetch('/odontologos',{
                method: 'GET',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                }
            })
            .then(function (response) {
                return response.json()
            })
            .then(function (odontologos) {
                let odontologoHtml = "";

                for (const odontologo of odontologos) {
                  odontologoHtml += '<tr id="odontologoId' + odontologo.id + '">' +
                      '<td>' + odontologo.id + '</td>' +
                      '<td class="td_first_name">' + odontologo.nombre.toUpperCase() + '</td>' +
                      '<td class="td_last_name">' + odontologo.apellido.toUpperCase() + '</td>' +
                      '<td class="td_matricula">' + odontologo.matricula.toUpperCase() + '</td>' +
                      '<td>' +
                        '<a type="button" class="edit" data-toggle="modal" data-target="#exampleModal"><i class="fas fa-edit" id="update_' + odontologo.id + '"></i></a>' +
                      '</td>' +
                    '</tr>';
                }
                document.querySelector('#odontologoTable tbody').innerHTML = odontologoHtml;
                mostrarPorId();
                borrarOdontologo();
            })
            .catch(function (error) {
                console.log(error);
            })
}

function mostrarPorId(){

    const btns = document.querySelectorAll(".edit");

    btns.forEach(item => {
        item.addEventListener("click", (e) => {
            const [,id] = e.target.id.split("_")

             fetch(('/odontologos/' + id),{
                method: 'GET',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                }
            })
            .then(function (response) {
                return response.json()
            })
            .then(function (odontologo) {

                document.querySelector("#id-odontologo").value = odontologo.id;
                document.querySelector("#nombre").value = odontologo.nombre;
                document.querySelector("#apellido").value = odontologo.apellido;
                document.querySelector("#matricula").value = odontologo.matricula;
                editarOdontologo();
            })
            .catch(function (error) {
                console.log(error);
            })
        })
    })
}
