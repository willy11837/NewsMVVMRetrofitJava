package com.android.mvvmretrofitjava.model.NewsModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsBean {

    @SerializedName("getVector")
    private GetVectorDTO getVector;

    public GetVectorDTO getGetVector() {
        return getVector;
    }

    public void setGetVector(GetVectorDTO getVector) {
        this.getVector = getVector;
    }

    public static class GetVectorDTO {
        @SerializedName("items")
        private List<ItemsDTOX> items;

        public List<ItemsDTOX> getItems() {
            return items;
        }

        public void setItems(List<ItemsDTOX> items) {
            this.items = items;
        }

        public static class ItemsDTOX {
            @SerializedName("type")
            private String type;
            @SerializedName("title")
            private String title;
            @SerializedName("_meta")
            private MetaDTO meta;
            @SerializedName("style")
            private String style;
            @SerializedName("source")
            private String source;
            @SerializedName("ref")
            private String ref;
            @SerializedName("appearance")
            private AppearanceDTO appearance;
            @SerializedName("extra")
            private ExtraDTO extra;
            @SerializedName("items")
            private List<ItemsDTO> items;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public MetaDTO getMeta() {
                return meta;
            }

            public void setMeta(MetaDTO meta) {
                this.meta = meta;
            }

            public String getStyle() {
                return style;
            }

            public void setStyle(String style) {
                this.style = style;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getRef() {
                return ref;
            }

            public void setRef(String ref) {
                this.ref = ref;
            }

            public AppearanceDTO getAppearance() {
                return appearance;
            }

            public void setAppearance(AppearanceDTO appearance) {
                this.appearance = appearance;
            }

            public ExtraDTO getExtra() {
                return extra;
            }

            public void setExtra(ExtraDTO extra) {
                this.extra = extra;
            }

            public List<ItemsDTO> getItems() {
                return items;
            }

            public void setItems(List<ItemsDTO> items) {
                this.items = items;
            }

            public static class MetaDTO {
                @SerializedName("section")
                private String section;
                @SerializedName("category")
                private List<String> category;

                public String getSection() {
                    return section;
                }

                public void setSection(String section) {
                    this.section = section;
                }

                public List<String> getCategory() {
                    return category;
                }

                public void setCategory(List<String> category) {
                    this.category = category;
                }
            }

            public static class AppearanceDTO {
                @SerializedName("mainTitle")
                private String mainTitle;
                @SerializedName("subTitle")
                private String subTitle;
                @SerializedName("thumbnail")
                private String thumbnail;
                @SerializedName("subscript")
                private String subscript;

                public String getMainTitle() {
                    return mainTitle;
                }

                public void setMainTitle(String mainTitle) {
                    this.mainTitle = mainTitle;
                }

                public String getSubTitle() {
                    return subTitle;
                }

                public void setSubTitle(String subTitle) {
                    this.subTitle = subTitle;
                }

                public String getThumbnail() {
                    return thumbnail;
                }

                public void setThumbnail(String thumbnail) {
                    this.thumbnail = thumbnail;
                }

                public String getSubscript() {
                    return subscript;
                }

                public void setSubscript(String subscript) {
                    this.subscript = subscript;
                }
            }

            public static class ExtraDTO {
                @SerializedName("created")
                private Integer created;

                public Integer getCreated() {
                    return created;
                }

                public void setCreated(Integer created) {
                    this.created = created;
                }
            }

            public static class ItemsDTO {
                @SerializedName("type")
                private String type;
                @SerializedName("source")
                private String source;
                @SerializedName("ref")
                private String ref;
                @SerializedName("appearance")
                private AppearanceDTOX appearance;
                @SerializedName("extra")
                private ExtraDTOX extra;
                @SerializedName("_meta")
                private MetaDTOX meta;

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getSource() {
                    return source;
                }

                public void setSource(String source) {
                    this.source = source;
                }

                public String getRef() {
                    return ref;
                }

                public void setRef(String ref) {
                    this.ref = ref;
                }

                public AppearanceDTOX getAppearance() {
                    return appearance;
                }

                public void setAppearance(AppearanceDTOX appearance) {
                    this.appearance = appearance;
                }

                public ExtraDTOX getExtra() {
                    return extra;
                }

                public void setExtra(ExtraDTOX extra) {
                    this.extra = extra;
                }

                public MetaDTOX getMeta() {
                    return meta;
                }

                public void setMeta(MetaDTOX meta) {
                    this.meta = meta;
                }

                public static class AppearanceDTOX {
                    @SerializedName("mainTitle")
                    private String mainTitle;
                    @SerializedName("subTitle")
                    private String subTitle;
                    @SerializedName("thumbnail")
                    private String thumbnail;
                    @SerializedName("subscript")
                    private String subscript;

                    public String getMainTitle() {
                        return mainTitle;
                    }

                    public void setMainTitle(String mainTitle) {
                        this.mainTitle = mainTitle;
                    }

                    public String getSubTitle() {
                        return subTitle;
                    }

                    public void setSubTitle(String subTitle) {
                        this.subTitle = subTitle;
                    }

                    public String getThumbnail() {
                        return thumbnail;
                    }

                    public void setThumbnail(String thumbnail) {
                        this.thumbnail = thumbnail;
                    }

                    public String getSubscript() {
                        return subscript;
                    }

                    public void setSubscript(String subscript) {
                        this.subscript = subscript;
                    }
                }

                public static class ExtraDTOX {
                    @SerializedName("created")
                    private Integer created;

                    public Integer getCreated() {
                        return created;
                    }

                    public void setCreated(Integer created) {
                        this.created = created;
                    }
                }

                public static class MetaDTOX {
                    @SerializedName("section")
                    private String section;
                    @SerializedName("category")
                    private List<String> category;

                    public String getSection() {
                        return section;
                    }

                    public void setSection(String section) {
                        this.section = section;
                    }

                    public List<String> getCategory() {
                        return category;
                    }

                    public void setCategory(List<String> category) {
                        this.category = category;
                    }
                }
            }
        }
    }
}
