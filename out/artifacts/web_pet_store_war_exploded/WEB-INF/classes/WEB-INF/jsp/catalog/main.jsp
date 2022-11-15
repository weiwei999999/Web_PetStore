<%@ include file="../common/top.jsp"%>
<link rel="StyleSheet" href="css/main.css" type="text/css"
      media="screen" />

<div id="Welcome">
    <div id="WelcomeContent">
          <!--显示登录用户的firstname-->
    </div>
</div>

<div id="Main">
    <div id="Sidebar">
        <div id="SidebarContent">
            <br>
            <a href="categoryForm?categoryId=FISH"><img src="images/fish_icon.jpg"> </a> <br />
            Fish from Saltwater, Freshwater
            <br>
            <br />

            <a href="categoryForm?categoryId=DOGS"><img src="images/dogs_icon.jpg"></a> <br />
            All kinds of Dogs <br />
            <br>
            <br />

            <a href="categoryForm?categoryId=CATS"><img src="images/cats_icon.jpg"/> </a> <br />
            Cats of Various Breeds
            <br>
            <br />

            <a href="categoryForm?categoryId=REPTILES"><img src="images/rep_icon.jpg"/></a> <br />
            Lizards, Turtles, Snakes
            <br>
            <br />

            <a href="categoryForm?categoryId=BIRDS"><img src="images/birds_icon.jpg"/> </a><br />
            Birds of Exotic Varieties
            <br />
        </div>
    </div>

    <div id="upLine">
        <h1>Welcome to Pet Store, feel free to choose !</h1>
        <h3>click pictures on the left or below to choose pets</h3>
    </div>

    <div class="loop-wrap">
        <div class="loop-images-container">
            <a href="categoryForm?categoryId=CATS">
                <img src="images/cat1.jpg" alt="" class="loop-image">
            </a>

            <a href="categoryForm?categoryId=DOGS">
                <img src="images/dog1.jpg" alt="" class="loop-image">
            </a>

            <a href="categoryForm?categoryId=REPTILES">
            <img src="images/snake1.jpg" alt="" class="loop-image">
            </a>

            <a href="categoryForm?categoryId=BIRDS">
            <img src="images/bird1.jpg" alt="" class="loop-image">
            </a>

            <a href="categoryForm?categoryId=FISH">
            <img src="images/fish1.jpg" alt="" class="loop-image">
            </a>
        </div>
    </div>

    <div id="downLine">
        Safe Haven is a nonprofit organization that rescues dogs from the Southern US, many of whom are in imminent danger of death. Most of Safe Haven's rescues come from the rural south in an area where dogs are abandoned at the county dump. Since the local shelters cannot handle the demand, Safe Haven collects and transports the dogs to the upper Midwest, where they are spayed or neutered, given veterinary carem and placed in loving foster homes while they await adoption. One of Petstore.com's staff is personally involved in fostering dogs. Safe Haven holds regular adoption events throughout the Chicagoland area where these wonderful animals find their forever homes.
    </div>

    <!--
        <div id="MainImage">
            <div id="MainImageContent">
                <map name="estoremap">
                    <area alt="Birds" coords="72,2,280,250"
                          href="categoryForm?categoryId=BIRDS" shape="RECT" />
                    <area alt="Fish" coords="2,180,72,250"
                          href="categoryForm?categoryId=FISH" shape="RECT" />
                    <area alt="Dogs" coords="60,250,130,320"
                          href="categoryForm?categoryId=DOGS" shape="RECT" />
                    <area alt="Reptiles" coords="140,270,210,340"
                          href="categoryForm?categoryId=REPTILES" shape="RECT" />
                    <area alt="Cats" coords="225,240,295,310"
                          href="categoryForm?categoryId=CATS" shape="RECT" />
                    <area alt="Birds" coords="280,180,350,250"
                          href="categoryForm?categoryId=BIRDS" shape="RECT" />
                </map>
                <img height="355" src="images/splash.gif" align="middle"
                     usemap="#estoremap" width="350" /></div>
        </div>
    -->

    <div id="Separator"></div>
</div>
<%@ include file="../common/bottom.jsp"%>