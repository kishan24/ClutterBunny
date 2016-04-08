<div class="container">
	<div class="row">
		<div class="col-lg-12 text-center">
			<h2>Contact Me</h2>
			<hr class="star-primary">
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12 text-center">
                <h2>Book Registry</h2>
         </div>
            
		<div class="col-lg-8 col-lg-offset-2">
			<form class="form-horizontal">
				<div class="form-group">
					<label for="inEmail" class="col-sm-2 control-label">Email</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="inEmail" placeholder="Email">
					</div>
				</div>
				<div class="form-group">
					<label for="inFN" class="col-sm-2 control-label">First Name</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inFN" placeholder="First Name">
					</div>
				</div>
				<div class="form-group">
					<label for="inLN" class="col-sm-2 control-label">Last Name</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inLN" placeholder="Last Name">
					</div>
				</div>
				<div class="form-group">
					<label for="inSN" class="col-sm-2 control-label">School Name</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inSN" placeholder="School Name">
					</div>
				</div>
				<div class="form-group">
					<label for="inBN" class="col-sm-2 control-label">Book Name</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inBN" placeholder="Book Name">
					</div>
				</div>
				<div class="form-group">
					<label for="inIsbn" class="col-sm-2 control-label">ISBN Number</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inIsbn" placeholder="ISBN">
					</div>
				</div>
				<div class="form-group">
					<label for="inQunatity" class="col-sm-2 control-label">Quantity</label>
					<div class="col-sm-10">
						<input type="number" class="form-control" id="inQunatity" placeholder="0">
					</div>
				</div>
				<div class="form-group">
					<label for="inWhen" class="col-sm-2 control-label">When</label>
					<div class="col-sm-10">
						<input type="date" class="form-control" id="inWhen" placeholder="When needed">
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="reset" class="btn btn-default">Reset</button>
						<button id="registerBtn" type="button" class="btn btn-primary">Register</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>



<div id="success" class="modal fade" tabindex="-1" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Confirmation</h4>
      </div>
      <div class="modal-body">
        <p>Book is successfully registered.</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<script>

$(function() {
   $('#registerBtn').click(function() {
	   var inp = {};
	   inp.email = $('#inEmail').val();
	   inp.firstName = $('#inFN').val();
		inp.lastName = $('#inLN').val();
		inp.schoolName = $('#inSN').val();
		inp.isbnNumber = $('#inIsbn').val();
		inp.bookName = $('#inBN').val();
		inp.quantity = $('#inQunatity').val();
		inp.expectedDate = $('#inWhen').val();
	   $.ajax({
		  method:"POST",
		  data:inp,
		  url:"book/add",
		  success:function(resp) {
			  $('#success').modal('show')
		  }
	   });
   }); 
});

</script>