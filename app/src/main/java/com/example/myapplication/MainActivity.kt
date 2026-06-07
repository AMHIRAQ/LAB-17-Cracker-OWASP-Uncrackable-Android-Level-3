package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "making owasp great again",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

/**
 * Validation de l'étape - LAB 17 : Cracker OWASP Uncrackable Android Level 3
 *
 * La méthode check.check_code() sert de pont JNI (Java Native Interface), déléguant la vérification
 * de la saisie utilisateur à la couche native pour complexifier l'analyse. La fonction native
 * FUN_001012c0 est le cœur du challenge : c'est elle qui initialise et manipule le buffer contenant
 * le secret encodé. On y observe des indices d'obfuscation classiques (type Tigress ou O-LLVM) tels
 * que des calculs LCG, des appels malloc(0x10) superflus et la gestion de listes chaînées opaques
 * visant à noyer la logique utile dans du "code mort". Le buffer final est la clé du challenge car
 * il contient les 24 octets du secret masqués par un XOR ; une fois ces octets extraits à la fin de
 * la fonction, il suffit de leur appliquer la clé "pizzapizza..." identifiée en Java pour révéler
 * le code secret : making owasp great again.
 */
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("making owasp great again")
    }
}