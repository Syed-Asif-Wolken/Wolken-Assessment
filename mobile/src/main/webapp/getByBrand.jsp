<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Mobile Index</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
 <header>
      <nav class="navbar navbar-light bg-fb-blue sticky-top">
        <div class="container-fluid">
          <a class="navbar-brand badge text-primary"><h1>MOBILE</h1></a>
          <div>
          <a href="index.jsp"><button class="btn btn-primary" type="submit"><h6>Save Data</h6></button></a>
          <a href="updatePrice.jsp"><button class="btn btn-primary" type="submit"><h6>update price</h6></button></a>
          <a href="updateAvailability.jsp"><button class="btn btn-primary" type="submit"><h6>update availability</h6></button></a>
          <a href="getByPrice.jsp"><button class="btn btn-primary" type="submit"><h6>Get By price</h6></button></a> 
        </div>
        </div>
      </nav>
    </header>
  
<section> 
        <div class="container fs-6">
            <div class="row">
              <div class="col card card-round shade-light push-down shadow-lg p-3 mb-5 bg-white rounded">
                <div class="card-body p-4 p-md-5">
                <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Brand Details</h3>
                <form action="get-by-brand" method="Get" class="row g-3">                    
                    <div class="col-md-12">
                        <label for="brandName" class="form-label">Brand Name</label>
                        <input type="text" id="brandName" class="form-control" name="brandName" placeholder="Brand name" aria-label="Brand name">
                      </div>
                      <div class="col-md-12" id="signup_name">
                      </div>
                    <div class="col-md-3">
                      <button type="submit" name="signup" value="Save" class="btn btn-primary submitter">Get Data</button>
                    </div>
                    <div class="col-md-2">
                        <button type="reset" class="btn btn-primary">Reset</button>
                      </div>
                      </form>
                  </div>
              </div>
              <div class="col-sm-6">
              </div>
            </div>
          </div>
      </section>
      
<footer class="text-center ft1 fixed-bottom"><h6>&copy;Copyrights Reserved</h6></footer>
    
</body>
</html>
