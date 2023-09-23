package com.shreyanshsingh21BCE10379.internship

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.shreyanshsingh21BCE10379.internship.ui.theme.ExternshipTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExternshipTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds,
            alpha = 0.3f
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Login",
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier.padding(bottom = 40.dp),
                fontFamily = FontFamily.Cursive
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(text = "Username") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Person, contentDescription = "Username Icon"
                    )
                },
                modifier = Modifier.padding(top = 10.dp, bottom = 20.dp),
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Password") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Lock, contentDescription = "Password Icon"
                    )
                },
                modifier = Modifier.padding(bottom = 20.dp)
            )
            Spacer(modifier = Modifier.height(50.dp))
            Button(onClick = { navController.navigate("RestaurantList") }) {
                Text(text = "Login", style = MaterialTheme.typography.titleLarge)
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantList(navController: NavController) {
    val restaurants = listOf("McDonald's", "KFC", "Taco Bell", "Burger King")
    val restaurantImages =
        listOf(R.drawable.mcdonalds, R.drawable.kfc, R.drawable.taco_bell, R.drawable.bk)
    val ratings = listOf("3.9", "4.3", "4.5", "4.1")
    val distance = listOf("1", "2", "5", "3")
    val timeToOrder = listOf("30", "25", "45", "35")
    Scaffold(topBar = {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(60.dp)
                .background(MaterialTheme.colorScheme.primaryContainer)
        ) {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "Home",
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "Restaurant List",
                modifier = Modifier.weight(5f),
                style = MaterialTheme.typography.titleLarge
            )
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Cart",
                modifier = Modifier.weight(1f)
            )
        }
    }, content = {
        LazyColumn(contentPadding = it, content = {
            itemsIndexed(restaurants) { x, item ->
                Card(
                    onClick = { navController.navigate("Menu/" + restaurants[x]) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 10.dp),
                    elevation = CardDefaults.cardElevation(20.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top
                    ) {
                        Image(
                            painter = painterResource(id = restaurantImages[x]),
                            contentDescription = "McDonald's",
                            contentScale = ContentScale.FillWidth,
                            modifier = Modifier.height(200.dp)
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start,
                            modifier = Modifier.padding(
                                horizontal = 15.dp, vertical = 10.dp
                            )
                        ) {
                            Text(
                                text = item,
                                style = MaterialTheme.typography.headlineMedium,
                                modifier = Modifier.weight(4f)
                            )
                            Badge(
                                modifier = Modifier.weight(1f), containerColor = Color(0xFF568940)
                            ) {
                                Text(
                                    text = ratings[x],
                                    textAlign = TextAlign.End,
                                    style = MaterialTheme.typography.titleMedium,
                                    color = Color.White
                                )
                                Icon(
                                    imageVector = Icons.Filled.Star,
                                    contentDescription = "Rating",
                                    tint = Color.White,
                                    modifier = Modifier
                                        .height(30.dp)
                                        .padding(start = 1.dp)
                                )
                            }
                        }
                        Row(modifier = Modifier.padding(horizontal = 15.dp)) {
                            Icon(
                                imageVector = Icons.Filled.Place, contentDescription = "Distance"
                            )
                            Text(
                                text = distance[x] + " km away",
                                style = MaterialTheme.typography.titleMedium,
                                modifier = Modifier.padding(start = 5.dp)
                            )
                        }
                        Row(
                            modifier = Modifier.padding(
                                horizontal = 15.dp, vertical = 15.dp
                            )
                        ) {
                            Icon(
                                imageVector = Icons.Filled.DateRange, contentDescription = "Time"
                            )
                            Text(
                                text = "Delivery in " + timeToOrder[x] + " mins",
                                style = MaterialTheme.typography.titleMedium,
                                modifier = Modifier.padding(start = 5.dp)
                            )
                        }
                    }
                }
            }
        })
    })
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Menu(navController: NavController, restaurant: String) {
    val menuItems = when (restaurant) {
        "McDonald's" -> listOf("Chicken Burger", "Fries", "Veg Burger", "Cold Drinks", "Ice Cream")
        "KFC" -> listOf(
            "Chicken Popcorn",
            "Hot & Crispy Chicken",
            "Grilled Chicken",
            "Chicken Wings",
            "Chicken Burger"
        )

        "Taco Bell" -> listOf(
            "Crispy Chicken Wrap", "Veggie Taco", "Burrito", "Taco Mexican", "Chicken Taco"
        )

        "Burger King" -> listOf(
            "Cheese Chicken Whopper",
            "Veggie Burger",
            "Berry Blast",
            "Veggie Strips",
            "Boneless Wings"
        )

        else -> listOf("Chicken Burger", "Fries", "Veg Burger", "Cold Drinks", "Ice Cream")
    }
    val restaurantImage = when (restaurant) {
        "McDonald's" -> R.drawable.mcdonalds
        "KFC" -> R.drawable.kfc
        "Taco Bell" -> R.drawable.taco_bell
        "Burger King" -> R.drawable.bk
        else -> R.drawable.mcdonalds
    }
    val menuImages = listOf(
        R.drawable.chicken_burger,
        R.drawable.fries,
        R.drawable.veg_burger,
        R.drawable.cold_drinks,
        R.drawable.ice_cream
    )
    val price = listOf("₹120", "₹110", "₹100", "₹140", "₹150")
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val itemsInCart = remember { mutableIntStateOf(0) }
    Scaffold(snackbarHost = { SnackbarHost(snackbarHostState) }, topBar = {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(60.dp)
                .background(MaterialTheme.colorScheme.primaryContainer)
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                )
            }
            Text(
                text = restaurant,
                modifier = Modifier.weight(5f),
                style = MaterialTheme.typography.titleLarge
            )
            BadgedBox(badge = {
                Badge(
                    modifier = Modifier.offset(x = (-20).dp)
                ) {
                    Text(text = itemsInCart.intValue.toString())
                }
            }, modifier = Modifier.weight(1f), content = {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart, contentDescription = "Cart"
                )
            })
        }
    }) {
        LazyColumn(contentPadding = it) {
            itemsIndexed(menuItems) { x, item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 10.dp),
                    elevation = CardDefaults.cardElevation(10.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = if (restaurant != "McDonald's") restaurantImage else menuImages[x]),
                            contentDescription = "Restaurant Image",
                            modifier = Modifier.weight(2f).height(100.dp),
                            contentScale = ContentScale.FillWidth
                        )
                        Column(
                            modifier = Modifier
                                .weight(3f)
                                .padding(start = 10.dp),
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = item, style = MaterialTheme.typography.headlineSmall
                            )
                            Text(text = price[x], style = MaterialTheme.typography.labelLarge)
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {
                        Button(onClick = {
                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    message = menuItems[x] + " added to Cart",
                                    duration = SnackbarDuration.Short,
                                    withDismissAction = true
                                )
                            }
                            itemsInCart.intValue++
                        }) {
                            Text(
                                text = "Add to Cart",
                                style = MaterialTheme.typography.labelLarge,
                                modifier = Modifier.padding(end = 5.dp)
                            )
                            Icon(
                                imageVector = Icons.Filled.ShoppingCart,
                                contentDescription = "Add to Cart"
                            )
                        }
                    }
                }
            }
        }
    }
}
