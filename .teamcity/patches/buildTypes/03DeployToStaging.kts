package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_2.*
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v2018_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2018_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = '03DeployToStaging'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("03DeployToStaging")) {
    expectSteps {
        script {
            name = "IIS Deploy"
            scriptContent = """
                rmdir /S /Q \inetpub\wwwroot
                xcopy /S /I /Y app \inetpub\wwwroot\
            """.trimIndent()
        }
    }
    steps {
        update<ScriptBuildStep>(0) {
            scriptContent = """
                rmdir /S /Q \www\Cards
                xcopy /S /I /Y app \www\Cards\
            """.trimIndent()
        }
    }
}
