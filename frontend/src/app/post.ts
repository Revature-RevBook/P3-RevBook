export interface Post{
    post_id?: Number,
    post_title: string,
    created_at?: Date,
    updated_at?: Date,
    post_content: string
    // Still not sure how to store images
    post_img?: String
}