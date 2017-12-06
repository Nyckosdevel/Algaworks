$('#confExclusao').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget); // Pego o evento do botão do modal

    var codigoTitulo = button.data('codigo');
    var descricaoTitulo = button.data('descricao');

    var modal = $(this);
    var form = modal.find('form');
    var action = form.data('url-base');
    if (!action.endsWith('/')) {
        action += '/';
    }
    form.attr('action', action + codigoTitulo);

    modal.find('.modal-body span').html('Tem certeza que deseja excluir <strong>' + descricaoTitulo + '</strong?');
});

$(function () {
//    $('[rel="tooltip"]').tooltip();
//    $('.js-money').mask('#.##0,00', {reverse: true});
//    $('#js-data').mask('##/##/####');
//    return true;
    $('[rel="tooltip"]').tooltip();
    $('.js-currency').maskMoney({decimal: ',', thousands: '.', allowZero: true});


    $('.js-status').on('click', function (event) {
        event.preventDefault();
        var botaoReceber = $(event.currentTarget);
        var urlReceber = botaoReceber.attr('href');
    });
});