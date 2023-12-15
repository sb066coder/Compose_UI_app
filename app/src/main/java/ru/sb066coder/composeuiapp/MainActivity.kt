package ru.sb066coder.composeuiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.sb066coder.composeuiapp.ui.theme.ComposeUIAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUIAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        verticalArrangement = Arrangement.Top,
                        modifier = Modifier
                    ) {
                        HeaderImage()
                        ContentText(
                            headerText = getString(R.string.header),
                            introText = getString(R.string.intro),
                            content = getString(R.string.content)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ContentText(
    headerText: String,
    introText: String,
    content: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier
    ) {
        Text(
            text = headerText,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)

        )
        Text(
            text = introText,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp
                ),
            textAlign = TextAlign.Justify
        )
        Text(
            text = content,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun HeaderImage(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Image(
        modifier = modifier,
        painter = image,
        contentDescription = null
    )
}

@Preview(showBackground = false)
@Composable
fun HeaderPreview() {
    ComposeUIAppTheme {
        HeaderImage()
    }
}

@Preview(showBackground = true)
@Composable
fun ContentTextPreview() {
    ComposeUIAppTheme {
        ContentText(
            headerText = stringResource(R.string.header),
            introText = stringResource(R.string.intro),
            content = stringResource(R.string.content)
        )
    }
}