package api;

import db.AdminDb;
import db.CarteDb;
import db.ProdusDb;
import db.UserDb;
import models.dao.Admin;
import models.dao.Carte;
import models.dao.Produs;
import models.dao.User;
import utils.DbManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.OK;

@Path("/v1")
public class Repository {
    private final CarteDb carteDb;
    private final AdminDb adminDb;
    private final UserDb userDb;
    private final ProdusDb produsDb;

    public Repository() {
        DbManager dbManager = new DbManager();
        carteDb = new CarteDb(dbManager);
        adminDb = new AdminDb(dbManager);
        userDb = new UserDb(dbManager);
        produsDb = new ProdusDb(dbManager);
    }


    /*----------------Admin----------------*/
    @GET
    @Path("/admins")
    @Produces({MediaType.APPLICATION_JSON})
    public Response GetAdmins(){
        try {
            return Response.status(OK).entity(adminDb.getAdmins()).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(NOT_FOUND).build();
        }
    }

    @GET
    @Path("/admin/{idAdmin}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response GetAdmin(@PathParam("idAdmin") long id ){
        try{
            return Response.status(OK).entity(adminDb.getAdmin(id)).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(NOT_FOUND).build();
        }
    }

    @POST
    @Path("/admin/add")
    @Produces({MediaType.APPLICATION_JSON})
    public Response AddAdmin(Admin admin){
        try{
            adminDb.addAdmin(admin);
            return Response.status(OK).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/admin/update/{idAdmin}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response UpdateAdmin(@PathParam("idAdmin") long id, Admin admin){
        try{
            adminDb.updateAdmin(id,admin);
            return Response.status(OK).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/admin/delete/{idAdmin}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response DeleteAdmin(@PathParam("idAdmin") long id){
        try {
            adminDb.deleteAdmin(id);
            return Response.status(OK).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(NOT_FOUND).build();
        }
    }

    /*----------------User----------------*/
    @GET
    @Path("/users")
    @Produces({MediaType.APPLICATION_JSON})
    public Response GetUsers(){
        try {
            return Response.status(OK).entity(userDb.getUsers()).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(NOT_FOUND).build();
        }
    }

    @GET
    @Path("/user/{idUser}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response GetUser(@PathParam("idUser") long id ){
        try{
            return Response.status(OK).entity(userDb.getUser(id)).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(NOT_FOUND).build();
        }
    }

    @POST
    @Path("/user/add")
    @Produces({MediaType.APPLICATION_JSON})
    public Response AddUser(User user){
        try{
            userDb.addUser(user);
            return Response.status(OK).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/user/update/{idUser}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response UpdateUser(@PathParam("idUser") long id, User user){
        try{
            userDb.updateUser(id,user);
            return Response.status(OK).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/user/delete/{idUser}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response DeleteUser(@PathParam("idUser") long id){
        try {
            userDb.deleteUser(id);
            return Response.status(OK).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(NOT_FOUND).build();
        }
    }


    /*----------------Product----------------*/
    @GET
    @Path("/products")
    @Produces({MediaType.APPLICATION_JSON})
    public Response GetProducts(){
        try {
            return Response.status(OK).entity(produsDb.getProduse()).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(NOT_FOUND).build();
        }
    }

    @GET
    @Path("/product/{idProduct}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response GetProduct(@PathParam("idProduct") long id ){
        try{
            return Response.status(OK).entity(produsDb.getProdus(id)).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(NOT_FOUND).build();
        }
    }

    @POST
    @Path("/product/add")
    @Produces({MediaType.APPLICATION_JSON})
    public Response AddProduct(Produs produs){
        try{
            produsDb.addProdus(produs);
            return Response.status(OK).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/product/update/{idProduct}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response UpdateProduct(@PathParam("idProduct") long id, Produs produs){
        try{
            produsDb.updateProdus(id,produs);
            return Response.status(OK).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/product/delete/{idProduct}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response DeleteProducts(@PathParam("idProduct") long id){
        try {
            produsDb.deleteProdus(id);
            return Response.status(OK).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(NOT_FOUND).build();
        }
    }


    /*-------------------Carti----------------*/
    @GET
    @Path("/carti")
    @Produces({MediaType.APPLICATION_JSON})
    public Response GetCarti(){
        try {
            return Response.status(OK).entity(carteDb.getCarti()).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(NOT_FOUND).build();
        }

    }

    @GET
    @Path("/carte/{idCarte}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response GetCarte(@PathParam("idCarte") long id ){
        try{
            return Response.status(OK).entity(carteDb.getCarte(id)).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(NOT_FOUND).build();
        }
    }

    @POST
    @Path("/addCarte")
    @Produces({MediaType.APPLICATION_JSON})
    public Response AddCarte(Carte carte){
        try{
            carteDb.postCarte(carte);
            return Response.status(OK).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/updateCarte/{idCarte}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response UpdateCarte(@PathParam("idCarte") long id, Carte carte){
        try{
            carteDb.updateCarte(id,carte);
            return Response.status(OK).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/deleteCarte/{idCarte}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response DeleteCarte(@PathParam("idCarte") long id){
        try {
            carteDb.deleteCarte(id);
            return Response.status(OK).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(NOT_FOUND).build();
        }
    }

}
