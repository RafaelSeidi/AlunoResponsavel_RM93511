package br.com.fiap.rafaelseidi_rm93511

data class ItemModel (
    val name: String,
    val cidade: String,
    val estado: String,
    val onRemove: (ItemModel) -> Unit
        )