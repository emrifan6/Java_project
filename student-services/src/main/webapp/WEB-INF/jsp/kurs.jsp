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

    <title>Kurs Mata Uang</title>
  </head>
  <body>
    <div class="contaiter mt-5" style="width: 30%;">
      <div class="container">
      <form>
        <fieldset disabled>
          <div class="form-group row">
            <label for="inputdate" class="col-sm-2 col-form-label">Date</label>
            <div class="col-sm-10">
              <input
                type="text"
                class="form-control"
                id="inputdate"
                name="user_id"
                value="${date}"
              />
            </div>
          </div>
          <div class="form-group row">
            <label for="inputbase" class="col-sm-2 col-form-label">Base</label>
            <div class="col-sm-10">
              <input
                type="text"
                class="form-control"
                id="inputbase"
                value="${base}"
              />
            </div>
          </div>
        </form>
      </div>
      <div class="container">
        <table class="table">
          <thead>
            <tr>
              <th scope="col">No</th>
              <th scope="col">Mata Uang</th>
              <th scope="col">Nilai</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th scope="row">1</th>
              <td>PKR</td>
              <td>${pkr}</td>
            </tr>
            <tr>
              <th scope="row">2</th>
              <td>GBP</td>
              <td>${gbp}</td>
            </tr>
            <tr>
              <th scope="row">3</th>
              <td>EUR</td>
              <td>${eur}</td>
            </tr>
            <tr>
              <th scope="row">4</th>
              <td>USD</td>
              <td>${usd}</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
      crossorigin="anonymous"
    ></script>
  </body>
</html>

<!-- <table class="table">
    <thead>
      <tr>
        <th scope="col"></th>
        <th scope="col">No</th>
        <th scope="col">GBP</th>
        <th scope="col">EUR</th>
        <th scope="col">USD</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <th scope="row">Rates</th>
        <th scope="row">${pkr}</th>
        <th scope="row">${gbp}</th>
        <th scope="row">${eur}</th>
        <th scope="row">${usd}</th>
      </tr>
    </tbody>
  </table> -->
