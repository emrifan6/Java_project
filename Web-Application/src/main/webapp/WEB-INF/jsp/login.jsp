<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>First Web Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>

<body>
<div class="container">
    <font color="red">${errorMessage}</font>

    <form method="post" >
        <table class="table table-bordered">
            <tr>
                <td><label for="name" class="form-label">Username: </label></td>
                <td><input type="text" class="form-control" id="name" aria-describedby="emailHelp" name="name"></td>
            </tr>
            <tr>
                <td><label for="password" class="form-label">Password: </label></td>
                <td><input type="password" class="form-control" id="password" name="password"></td>
            </tr>
            <tr>
                <td colspan="2"><button type="submit" class="btn btn-primary">Submit</button></td>
            </tr>

        </table>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>

</html>