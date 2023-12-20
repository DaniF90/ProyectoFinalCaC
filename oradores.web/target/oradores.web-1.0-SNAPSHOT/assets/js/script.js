new DataTable('#example');

$('#example').DataTable( {
    responsive: true
} );

const myModal = bootstrap.Modal.getOrCreateInstance('#modal1');

            window.addEventListener('shown.bs.modal', () => {
                myModal.show();
            });