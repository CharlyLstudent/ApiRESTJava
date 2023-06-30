package com.springdonjon.donjonanddragonjava;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonnageController {

    private static List<Personnage> personnages = new ArrayList<>();
    private int idCount;

    @GetMapping("/personnage")
    @Operation(
            description = "Affiche la liste des personnages",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "la liste à été chargée avec succès ! ",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\n" +
                                                            "  \"id\": 0,\n" +
                                                            "  \"name\": \"string\",\n" +
                                                            "  \"type\": \"magicien\",\n" +
                                                            "  \"health\": 0\n" +
                                                            "}"
                                            )
                                    }
                            )
                    )
            }
    )
    public List<Personnage> getPersonnage() {

        return personnages;
    }

    @PostMapping("/personnage")
    @Operation(
            description = "Ajoute un personnage à la liste des personnages",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Personnage ajouté avec succès ! ",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "string"
                                            )
                                    }
                            )
                    )
            }
    )
    public Personnage ajouterPersonnage(
            @RequestBody Personnage needed) {

        String name = needed.getName();
        String type = String.valueOf(needed.getType());

        Personnage newPersonnage = new Personnage(name,PersonType.valueOf(type) , this.idCount);

        personnages.add(newPersonnage);
        this.idCount++;

        return newPersonnage;
    }

    @GetMapping("/personnage/{id}")
    @PostMapping("/personnage")
    @Operation(
            description = "Trouve un personnage grâce à son ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Personnage trouvé !  ",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\n" +
                                                            "  \"id\": 0,\n" +
                                                            "  \"name\": \"string\",\n" +
                                                            "  \"type\": \"magicien\",\n" +
                                                            "  \"health\": 0\n" +
                                                            "}"
                                            )
                                    }
                            )
                    )
            }
    )
    public ResponseEntity<Personnage> findPersonnage(@PathVariable("id") int id) {

        Personnage personnage = personnages.stream().filter(person -> person.getId() == id).findFirst().orElse(null);

        return ResponseEntity.ok(personnage);
    }

    @PutMapping("/personnage/{id}")
    @Operation(
            description = "Modifie un personnage choisit via son ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Personnage modifié !  ",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\n" +
                                                            "  \"id\": 0,\n" +
                                                            "  \"name\": \"string\",\n" +
                                                            "  \"type\": \"magicien\",\n" +
                                                            "  \"health\": 0\n" +
                                                            "}"
                                            )
                                    }
                            )
                    )
            }
    )
    public ResponseEntity<Personnage> updatePersonnage(@PathVariable("id") int id,
                                                       @RequestBody Personnage needed) {

        Personnage personnage = personnages.stream().filter(person -> person.getId() == id).findFirst().orElse(null);

        personnage.setName(needed.getName());
        personnage.setType(needed.getType());

        return ResponseEntity.ok(personnage);
    }

    @DeleteMapping("/personnage/{id}")
    @Operation(
            description = "Supprime un personnage choisit via son ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Personnage modifié ! ",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "string"
                                            )
                                    }
                            )
                    )
            }
    )
    public void deletePersonnage(@PathVariable("id") int id) {
        Personnage personnage = personnages.stream().filter(person -> person.getId() == id).findFirst().orElse(null);
        personnages.remove(personnage);
    }
}
