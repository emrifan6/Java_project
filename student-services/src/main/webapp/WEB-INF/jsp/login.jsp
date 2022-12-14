<!-- <html>
  <head>
    <title>First Web Application</title>
  </head>

  <body>
    <font color="red">${message}</font>
    <form method="post">
      <label for="user_id">user_id:</label>
      <input type="user_id" name="user_id" />
      <br /><br />
      <label for="email">email:</label>
      <input type="email" name="email" />
      <br /><br />
      <label for="password">password:</label>
      <input type="password" name="password" />
      <br /><br />
      <label for="nomor_kartu">nomor_kartu:</label>
      <input type="nomor_kartu" name="nomor_kartu" />
      <br /><br />
      <label for="nomor_hp">nomor_hp:</label>
      <input type="nomor_hp" name="nomor_hp" />
      <br /><br />
      <button type="submit">Register</button>
    </form>
    <a href="/login">Login</a></span>
  </body>
</html> -->

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />

    <title>Hello, world!</title>
  </head>
  <body>
    <style>
      .pendaftaran-form {
        width: 800px;
        margin: 50px auto;
        font-size: 15px;
      }

      .pendaftaran-form form {
        margin-bottom: 15px;
        background: #f7f7f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
      }

      .pendaftaran-form h2 {
        margin: 0 0 15px;
      }

      .form-control,
      .btn {
        min-height: 38px;
        border-radius: 2px;
      }

      .btn {
        font-size: 15px;
        font-weight: bold;
      }
      .form-group {
        margin-bottom: 10px;
      }
    </style>

    <font color="red">${message}</font>
    <div class="pendaftaran-form">
      <form href="/register" method="post">
        <h2 class="text-center">Pendaftaran Akun</h2>
        <div class="form-group row">
          <label for="inputUserId" class="col-sm-2 col-form-label"
            >User ID</label
          >
          <div class="col-sm-10">
            <input
              type="text"
              class="form-control"
              id="inputUserId"
              placeholder="User ID"
              name="user_id"
              minlength="8"
              maxlength="32"
            />
          </div>
        </div>
        <div class="form-group row">
          <label for="inputPassword" class="col-sm-2 col-form-label"
            >Password</label
          >
          <div class="col-sm-10">
            <input
              type="password"
              class="form-control"
              id="inputPassword"
              placeholder="Password"
              name="password"
              minlength="8"
              maxlength="32"
            />
          </div>
        </div>
        <div class="form-group mb-2 text-center">
          <button type="submit" class="btn btn-primary btn-block">Masuk</button>
        </div>
      </form>
      <p class="text-center">
        <a href="/register">Pendaftaran</a>
      </p>
    </div>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
