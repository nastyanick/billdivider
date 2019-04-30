package com.nastynick.billdivider.data.objects

data class Contact(
    val id: Long?,
    val name: String?,
    val phone: String?,
    val email: String?,
    val photoUri: String?
) {
    companion object {
        fun from(contact: com.github.tamir7.contacts.Contact): Contact {
            return Contact(
                    id = contact.id,
                    name = contact.displayName,
                    phone = contact.phoneNumbers.elementAtOrNull(0)?.normalizedNumber,
                    email = contact.emails.elementAtOrNull(0)?.address,
                    photoUri = contact.photoUri
            )
        }
    }
}
