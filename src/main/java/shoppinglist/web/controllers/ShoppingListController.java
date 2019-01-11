package shoppinglist.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import shoppinglist.console.domains.ShoppingList;
import shoppinglist.console.domains.User;
import shoppinglist.console.services.shoppinglists.add.AddShoppingListRequest;
import shoppinglist.console.services.shoppinglists.add.AddShoppingListResponse;
import shoppinglist.console.services.shoppinglists.add.AddShoppingListService;
import shoppinglist.console.services.shoppinglists.get.GetShoppingListRequest;
import shoppinglist.console.services.shoppinglists.get.GetShoppingListResponse;
import shoppinglist.console.services.shoppinglists.get.GetShoppingListService;
import shoppinglist.console.services.shoppinglists.getAll.GetAllShoppingListsRequest;
import shoppinglist.console.services.shoppinglists.getAll.GetAllShoppingListsResponse;
import shoppinglist.console.services.shoppinglists.getAll.GetAllShoppingListsService;
import shoppinglist.console.services.shoppinglists.remove.RemoveShoppingListRequest;
import shoppinglist.console.services.shoppinglists.remove.RemoveShoppingListResponse;
import shoppinglist.console.services.shoppinglists.remove.RemoveShoppingListService;
import shoppinglist.web.dtos.ShoppingListDTO;

import java.util.List;

@Controller
@RequestMapping(value = "/shoppingList")
public class ShoppingListController {

    @Autowired
    private AddShoppingListService addShoppingListService;

    @Autowired
    private RemoveShoppingListService removeShoppingListService;

    @Autowired
    private GetShoppingListService getShoppingListService;

    @Autowired
    private GetAllShoppingListsService getAllShoppingListsService;


    @PostMapping(value = "/add")
    public ResponseEntity addShoppingList(@RequestBody ShoppingListDTO shoppingListDTO) {

        AddShoppingListRequest request = new AddShoppingListRequest(
                shoppingListDTO.getUser(), shoppingListDTO.getTitle());
        AddShoppingListResponse response = addShoppingListService.execute(request);

        if (!response.getShoppingListErrors().isEmpty()) {
            return new ResponseEntity<>(response.getShoppingListErrors(), HttpStatus.BAD_REQUEST);
        }
        shoppingListDTO.setId(response.getShoppingList().getId());
        return new ResponseEntity<>(shoppingListDTO, HttpStatus.CREATED);
    }

    @PostMapping(value = "/remove")
    public ResponseEntity removeShoppingList(@RequestBody ShoppingListDTO shoppingListDTO) {

        RemoveShoppingListRequest request = new RemoveShoppingListRequest(
                shoppingListDTO.getUser(), shoppingListDTO.getTitle());
        RemoveShoppingListResponse response = removeShoppingListService.execute(request);

        if (!response.getShoppingListErrors().isEmpty()) {
            return new ResponseEntity<>(response.getShoppingListErrors(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/get")
    public ResponseEntity getShoppingList(@RequestBody ShoppingListDTO shoppingListDTO) {

        GetShoppingListRequest request = new GetShoppingListRequest(
                shoppingListDTO.getUser(), shoppingListDTO.getTitle());
        GetShoppingListResponse response = getShoppingListService.execute(request);

        if (!response.getShoppingListErrors().isEmpty()) {
            return new ResponseEntity<>(response.getShoppingListErrors(), HttpStatus.NOT_FOUND);
        }
        shoppingListDTO.setId(response.getShoppingList().getId());
        return new ResponseEntity<>(shoppingListDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/getall")
    public ResponseEntity getAllShoppingLists(@RequestBody User user) {

        GetAllShoppingListsRequest request = new GetAllShoppingListsRequest(user);
        GetAllShoppingListsResponse response = getAllShoppingListsService.execute(request);

        if (!response.getShoppingListErrors().isEmpty()) {
            return new ResponseEntity<>(response.getShoppingListErrors(), HttpStatus.NOT_FOUND);
        }
        List<ShoppingList> shoppingLists = response.getShoppingLists();
        return new ResponseEntity<>(shoppingLists, HttpStatus.OK);
    }

}
