$(document).ready(function() {
    $('.infoBtn').on('click', function(event) {
		var bookId = $(this).attr('entryIndex');
		console.log(bookId);
	});

    $('.removeBtn').on('click', function(event) {
		var bookId = $(this).attr('entryIndex');
		$.get("/book/remove/" + bookId);
        window.location.reload(true);
	});

    //
	$('#consoleTestBtn').on('click', function(event) {
		console.log($('#myInput').val());
	});
    //
	// $('.table .editBtn').on('click', function(event) {
	// 	event.preventDefault();
	// 	var href = $(this).attr('href');
	// 	$.get(href, function(book, status) {
	// 		$('.myForm #id').val(book.id);
	// 		$('.myForm #title').val(book.title);
	// 		$('.myForm #author').val(book.author);
	// 	});
	// 	$('.myForm #editModal').modal();
	// });
	//
	// $('.addNewBookBtn').on('click', function(event) {
	// 	event.preventDefault();
	// 	var href = $(this).attr('href');
	// 	$.get(href, function(book, status) {
	// 		$('.myForm #id').val(book.id);
	// 		$('.myForm #title').val(book.title);
	// 		$('.myForm #author').val(book.author);
	// 	});
	// 	$('.myForm #editModal').modal();
	// });


});