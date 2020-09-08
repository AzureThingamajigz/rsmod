dependencies {
    implementation(kotlin("stdlib"))

    /* java/kotlin dependencies */
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${JvmVersions.COROUTINE_VERSION}")

    /* reflection dependencies */
    implementation("io.github.classgraph:classgraph:${ReflectionVersions.CLASSGRAPH}")

    /* kotlinscript dependencies */
    implementation("org.jetbrains.kotlin:kotlin-scripting-common:${JvmVersions.KOTLIN_VERSION}")
    implementation("org.jetbrains.kotlin:kotlin-script-runtime:${JvmVersions.KOTLIN_VERSION}")

    /* security dependencies */
    implementation("org.bouncycastle:bcprov-jdk15on:${SecurityVersions.BOUNCYCASTLE}")

    implementation("com.github.runelite.runelite:cache:runelite-parent-1.5.2.1")
}
