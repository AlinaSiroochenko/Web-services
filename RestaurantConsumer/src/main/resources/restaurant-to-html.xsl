<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html" indent="yes"/>
    <xsl:template match="/">
        <html lang="en">
            <head>
                <meta charset="UTF-8"/>
                <title>Restaurants</title>
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>
                <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700" rel="stylesheet"/>
                <style>
                    #restaurants-heading {
                    font-family: 'Roboto', sans-serif;
                    font-weight: 300;
                    }
                    .card-header, .general-info {
                    background-color: #007bff;
                    color: white;
                    font-size: 1.5rem;
                    font-weight: bold;
                    text-transform: uppercase;
                    padding: 0.5rem 1rem;
                    border: none;
                    border-radius: 0;
                    }
                    .general-info {
                    background-color: #f8f9fa;
                    color: #343a40;
                    font-size: 1rem;
                    padding: 0.5rem 1rem;
                    border-bottom: 2px solid #dee2e6;
                    border-radius: 0.25rem;
                    margin-bottom: 1rem;
                    }
                    .restaurant-card {
                    margin-bottom: 1rem;
                    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
                    transition: 0.3s;
                    }
                    .restaurant-card:hover {
                    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
                    }
                    .card-body {
                    font-size: 1rem;
                    }
                    .card-title {
                    margin-bottom: 1rem;
                    }
                </style>
            </head>
            <body>
                <div class="container mt-4">
                    <h1 id="restaurants-heading" class="display-4 text-center mb-4">Restaurants</h1>
                    <div class="row">
                        <xsl:apply-templates select="restaurants/restaurant"/>
                    </div>
                </div>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="restaurant">
        <div class="col-lg-6 col-xl-4">
            <div class="card restaurant-card mx-auto">
                <div class="card-header text-center">
                    <xsl:value-of select="name"/>
                </div>
                <div class="card-body">
                    <div class="general-info">
                        <p class="card-title">
                            Location: <xsl:value-of select="location"/>
                        </p>
                        <p class="card-text">
                            Rating: <xsl:value-of select="rating"/>
                        </p>
                    </div>
                    <xsl:apply-templates select="menu"/>
                </div>
            </div>
        </div>
    </xsl:template>

    <xsl:template match="menu">
        <h5 class="menu-heading">Menu:</h5>
        <ul class="list-unstyled">
            <xsl:apply-templates select="dish"/>
        </ul>
    </xsl:template>

    <xsl:template match="dish">
        <li class="menu-item">
            <xsl:value-of select="name"/> - $<xsl:value-of select="price"/>
        </li>
    </xsl:template>
</xsl:stylesheet>
